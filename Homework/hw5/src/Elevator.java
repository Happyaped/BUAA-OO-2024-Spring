import com.oocourse.elevator1.TimableOutput;

import java.util.ArrayList;
import java.util.HashMap;

public class Elevator extends Thread {
    private int idElevator;
    private RequestTable requestTable;//与Schedule分配后的共享,代表了电梯外的人的请求
    private HashMap<Integer, ArrayList<Person>> destMap;//在电梯里面的人的请求，key是目的层，！！list空了要删键值对
    private int nowNum;//记录当前电梯承载人数
    private int nowFloor;//记录当前电梯当前层数
    private int direction;//0为电梯向上，1为电梯向下
    private Strategy strategy;

    public Elevator(RequestTable requestTable, int idElevator) {
        this.requestTable = requestTable;
        this.idElevator = idElevator;
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
            Advice advice = strategy.getAdvice(nowNum, nowFloor, direction, destMap);
            if (advice == Advice.OVER) { //线程结束
                break;
            } else if (advice == Advice.MOVE) {
                move();
                //TimableOutput.println(22);
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

    public void move() {
        try {
            sleep(400);
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
                        if (nowNum == 6) {
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
                        if (nowNum == 6) {
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
