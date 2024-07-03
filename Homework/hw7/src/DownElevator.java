import java.util.ArrayList;
import java.util.HashMap;

import com.oocourse.elevator3.TimableOutput;

public class DownElevator extends Thread {
    private Integer idElevator;
    private RequestTable elevatorSchedule;//和电梯变成的调度器进行共享
    private RequestTable requestTable;//与Elevator分配后的共享,代表了电梯外的人的请求
    private HashMap<Integer, ArrayList<Person>> destMap;//在电梯里面的人的请求，key是目的层
    private Integer nowNum;//记录当前电梯承载人数
    private Integer nowFloor;//记录当前电梯当前层数
    private Integer direction;//0为电梯向上，1为电梯向下
    private Integer changeFloor;//代表换乘楼层
    private Strategy strategy;
    private Integer capacity;//满载人数
    private Integer moveTime;//电梯移动时间
    private IsInChangeFloorLock isInChangeFloorLock;//代表换乘楼层是否被占

    public DownElevator(Integer idElevator, RequestTable elevatorSchedule,
                        RequestTable requestTable, IsInChangeFloorLock isInChangeFloorLock) {
        this.idElevator = idElevator;
        this.elevatorSchedule = elevatorSchedule;
        this.requestTable = requestTable;
        this.isInChangeFloorLock = isInChangeFloorLock;
        destMap = new HashMap<>();
        nowNum = 0;
        direction = 1;//下轿厢电梯初始向上
        strategy = new Strategy(requestTable);
        for (int i = 1; i < 12; i++) {
            destMap.put(i, new ArrayList<>());
        }
    }

    @Override
    public void run() {
        while (true) {
            Advice advice = strategy.getDownAdvice(nowNum, nowFloor,
                    direction, destMap, capacity, changeFloor);
            if (advice == Advice.OVER) {
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

    public void move() {
        if (nowFloor == changeFloor) {
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
            TimableOutput.println("ARRIVE-" + nowFloor + "-" + idElevator + "-A");
            isInChangeFloorLock.setIsInChangeFloor(0);//离开了换乘楼层
            synchronized (isInChangeFloorLock) {
                isInChangeFloorLock.notifyAll();
            }
        } else if (nowFloor == changeFloor - 1 && direction == 0) {
            synchronized (isInChangeFloorLock) {
                int mark = isInChangeFloorLock.getIsInChangeFloor();
                if (mark == 0) {
                    //没有被占
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
                    TimableOutput.println("ARRIVE-" + nowFloor + "-" + idElevator + "-A");
                    isInChangeFloorLock.setIsInChangeFloor(1);
                } else if (mark == 1) {
                    //被占了
                    try {
                        isInChangeFloorLock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
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
            TimableOutput.println("ARRIVE-" + nowFloor + "-" + idElevator + "-A");
        }
    }

    public void openAndClose() {
        TimableOutput.println("OPEN-" + nowFloor + "-" + idElevator + "-A");
        try {
            sleep(400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //todo进人出人
        out();
        in();
        TimableOutput.println("CLOSE-" + nowFloor + "-" + idElevator + "-A");
    }

    public void out() {
        if (nowFloor == changeFloor) {
            if (destMap.get(nowFloor).size() != 0) {
                //有人出去
                ArrayList<Person> tem = destMap.get(nowFloor);
                for (int i = 0; i < tem.size(); i++) {
                    TimableOutput.println("OUT-" + tem.get(i).getId()
                            + "-" + nowFloor + "-" + idElevator + "-A");
                }
                nowNum = nowNum - destMap.get(nowFloor).size();
                tem.clear();
            }
            for (int i = nowFloor + 1; i < 12; i++) {
                if (destMap.get(i).size() != 0) {
                    ArrayList<Person> tem = destMap.get(i);
                    for (int j = 0; j < tem.size(); j++) {
                        TimableOutput.println("OUT-" + tem.get(j).getId()
                                + "-" + nowFloor + "-" + idElevator + "-A");
                        Person newOne = new Person(tem.get(j).getId(),
                                nowFloor, tem.get(j).getToFloor());
                        elevatorSchedule.addRequestMap(newOne);
                    }
                    nowNum = nowNum - destMap.get(i).size();
                    tem.clear();
                }
            }
        } else {
            if (destMap.get(nowFloor).size() != 0) {
                //有人出去
                ArrayList<Person> tem = destMap.get(nowFloor);
                for (int i = 0; i < tem.size(); i++) {
                    TimableOutput.println("OUT-" + tem.get(i).getId()
                            + "-" + nowFloor + "-" + idElevator + "-A");
                }
                nowNum = nowNum - destMap.get(nowFloor).size();
                tem.clear();
            }
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
                                    + "-" + nowFloor + "-" + idElevator + "-A");
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
                                    + "-" + nowFloor + "-" + idElevator + "-A");
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

    public void setChangeFloor(Integer changeFloor) {
        this.changeFloor = changeFloor;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public void setMoveTime(Integer moveTime) {
        this.moveTime = moveTime;
    }

    public void setNowFloor(Integer nowFloor) {
        this.nowFloor = nowFloor;
    }

    public boolean isAbleToEnd() {
        HashMap<Integer, ArrayList<Person>> tem = requestTable.getRequestMap();
        int mark = 0;
        for (int i = changeFloor + 1; i < 12; i++) {
            if (destMap.get(i).size() != 0) {
                mark = 1;
                break;
            }
        }
        for (int i = 1; i < 12; i++) {
            if (tem.get(i).size() != 0) {
                ArrayList<Person> tem1 = tem.get(i);
                for (Person item : tem1) {
                    if (item.getToFloor() > changeFloor) {
                        mark = 1;
                        break;
                    }
                }
            }
        }
        if (mark == 1) {
            return false;
        } else {
            return true;
        }

    }
}
