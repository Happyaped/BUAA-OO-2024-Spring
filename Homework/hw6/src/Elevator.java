import com.oocourse.elevator2.TimableOutput;

import java.util.ArrayList;
import java.util.HashMap;

public class Elevator extends Thread {
    private RequestTable mainRequestTable;
    private Integer idElevator;
    private RequestTable requestTable;//与Schedule分配后的共享,代表了电梯外的人的请求
    private HashMap<Integer, ArrayList<Person>> destMap;//在电梯里面的人的请求，key是目的层，！！list空了要删键值对
    private Integer nowNum;//记录当前电梯承载人数
    private Integer nowFloor;//记录当前电梯当前层数
    private Integer direction;//0为电梯向上，1为电梯向下
    private Boolean resetFlag;//是否reset
    private Strategy strategy;
    private Integer capacity;//满载人数
    private Integer moveTime;//电梯移动时间
    private Integer resetCapacity;//暂时记录保存修改的满载人数
    private Integer resetMoveTime;//暂时记录保存修改的电梯移动时间

    public Elevator(RequestTable requestTable, int idElevator, RequestTable mainRequestTable) {
        this.requestTable = requestTable;
        this.idElevator = idElevator;
        this.resetFlag = false;
        this.mainRequestTable = mainRequestTable;
        capacity = 6;
        moveTime = 400;
        resetCapacity = 6;
        resetMoveTime = 400;
        nowNum = 0;
        nowFloor = 1;
        direction = 0;
        strategy = new Strategy(requestTable);
        destMap = new HashMap<>();
        for (int i = 1; i < 12; i++) {
            destMap.put(i, new ArrayList<>());
        }
    }

    @Override
    public void run() {
        while (true) {
            Advice advice = strategy.getAdvice(nowNum, nowFloor, direction,
                    destMap, getResetFlag(), capacity);
            if (advice == Advice.RESET) {
                reset();
            } else if (advice == Advice.OVER) { //线程结束
                break;
            } else if (advice == Advice.MOVE) {
                move();
            } else if (advice == Advice.REVERSE) {
                if (direction == 0) {
                    direction = 1;
                } else {
                    direction = 0;
                }
            } else if (advice == Advice.WAIT) {
                synchronized (requestTable) {
                    try {
                        requestTable.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } else if (advice == Advice.OPEN) {
                openAndClose();
            }
        }
    }

    public void setResetFlag(Boolean resetFlag) {
        synchronized (this.resetFlag) {
            this.resetFlag = resetFlag;
        }
        synchronized (requestTable) {
            requestTable.notifyAll();
        }
    }

    public Boolean getResetFlag() {
        synchronized (resetFlag) {
            return resetFlag;
        }
    }

    public void setResetCapacity(Integer resetCapacity) {
        synchronized (this.resetCapacity) {
            this.resetCapacity = resetCapacity;
        }
    }

    public void setResetMoveTime(Integer resetMoveTime) {
        synchronized (this.resetMoveTime) {
            this.resetMoveTime = resetMoveTime;
        }
    }

    public Integer getResetCapacity() {
        synchronized (resetCapacity) {
            return resetCapacity;
        }
    }

    public Integer getResetMoveTime() {
        synchronized (resetMoveTime) {
            return resetMoveTime;
        }
    }

    public void reset() {
        //电梯出人
        int mark = 0;
        for (int key : destMap.keySet()) {
            if (destMap.get(key).size() != 0) {
                mark = 1;
                break;
            }
        }
        if (mark == 1) {
            TimableOutput.println("OPEN-" + nowFloor + "-" + idElevator);
            for (int key : destMap.keySet()) {
                ArrayList<Person> tem = destMap.get(key);
                if (tem.size() != 0) {
                    for (Person item : tem) {
                        TimableOutput.println("OUT-" + item.getId()
                                + "-" + nowFloor + "-" + idElevator);
                        if (item.getToFloor() != nowFloor) {
                            Person item1 = new Person(item.getId(), nowFloor, item.getToFloor());
                            requestTable.addRequestMap(item1);
                        }
                    }
                    tem.clear();
                }
            }
            try {
                sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            TimableOutput.println("CLOSE-" + nowFloor + "-" + idElevator);
        }
        nowNum = 0;
        TimableOutput.println("RESET_BEGIN-" + idElevator);
        mainRequestTable.receiveResetRequest(requestTable);
        try {
            sleep(1200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        TimableOutput.println("RESET_END-" + idElevator);
        setResetFlag(false);
        capacity = getResetCapacity();
        moveTime = getResetMoveTime();
        synchronized (mainRequestTable) {
            mainRequestTable.notifyAll();
        }
    }

    public void move() {
        try {
            sleep(moveTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (direction == 0) {
            nowFloor++;
        } else {
            nowFloor--;
        }
        TimableOutput.println("ARRIVE-" + nowFloor + "-" + idElevator);
    }

    public void openAndClose() {
        TimableOutput.println("OPEN-" + nowFloor + "-" + idElevator);
        try {
            sleep(400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //todo进人出人
        out();
        in();
        TimableOutput.println("CLOSE-" + nowFloor + "-" + idElevator);
    }

    public void out() {
        if (destMap.get(nowFloor).size() != 0) {
            //有人出去
            ArrayList<Person> tem = destMap.get(nowFloor);
            for (int i = 0; i < tem.size(); i++) {
                TimableOutput.println("OUT-" + tem.get(i).getId()
                        + "-" + nowFloor + "-" + idElevator);
            }
            nowNum = nowNum - destMap.get(nowFloor).size();
            tem.clear();
        } else {
            //没人出去
            return;
        }
    }

    public void in() {
        if (requestTable.getRequestMap().get(nowFloor).size() != 0) {
            //有人在这层想上电梯
            ArrayList<Person> tem = requestTable.getRequestMap().get(nowFloor);
            int upNum = 0;
            int downNum = 0;
            for (int i = 0; i < tem.size(); i++) {
                //遍历这层请求
                if (tem.get(i).getFromFloor() < tem.get(i).getToFloor()) {
                    upNum++;
                } else {
                    downNum++;
                }
            }
            if (direction == 0) {
                //如果电梯向上
                if (upNum > 0) {
                    ArrayList<Person> mark = new ArrayList<>();
                    for (int i = 0; i < tem.size(); i++) {
                        if (nowNum == capacity) {
                            break;
                        }
                        if (tem.get(i).getFromFloor() < tem.get(i).getToFloor()) {
                            nowNum++;
                            destMap.get(tem.get(i).getToFloor()).add(tem.get(i));
                            TimableOutput.println("IN-" + tem.get(i).getId()
                                    + "-" + nowFloor + "-" + idElevator);
                            mark.add(tem.get(i));
                        }
                    }
                    //System.out.println(mark.size()+"!!");
                    for (int i = 0; i < mark.size(); i++) {
                        tem.remove(mark.get(i));
                    }
                    //System.out.println(tem.size());
                } else {
                    return;
                }
            } else {
                //如果电梯向下
                if (downNum > 0) {
                    ArrayList<Person> mark = new ArrayList<>();
                    for (int i = 0; i < tem.size(); i++) {
                        if (nowNum == capacity) {
                            break;
                        }
                        if (tem.get(i).getFromFloor() > tem.get(i).getToFloor()) {
                            nowNum++;
                            destMap.get(tem.get(i).getToFloor()).add(tem.get(i));
                            TimableOutput.println("IN-" + tem.get(i).getId()
                                    + "-" + nowFloor + "-" + idElevator);
                            mark.add(tem.get(i));
                        }
                    }
                    for (int i = 0; i < mark.size(); i++) {
                        tem.remove(mark.get(i));
                    }
                } else {
                    return;
                }
            }
        } else {
            //没人在这层想上电梯
            return;
        }
    }
}
