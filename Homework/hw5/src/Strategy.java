import java.util.ArrayList;
import java.util.HashMap;

public class Strategy {
    private RequestTable requestTable;//电梯外的人的请求

    public Strategy(RequestTable requestTable) {
        this.requestTable = requestTable;
    }

    public Advice getAdvice(int nowNum, int nowFloor, int direction,
                            HashMap<Integer, ArrayList<Person>> destMap) {
        if (canOpenForOut(destMap, nowFloor) || canOpenForIn(nowFloor, direction, nowNum)) {
            return Advice.OPEN;
        }
        if (nowNum != 0) {
            return Advice.MOVE;
        } else {
            if (requestTable.isEmpty()) {
                //System.out.println("!!");
                if (requestTable.isEnd()) {
                    //System.out.println("!over");
                    return Advice.OVER;
                } else {
                    return Advice.WAIT;
                }
            }
            if (hasReqInOriginDirection(direction, nowFloor)) {
                return Advice.MOVE;
            } else {
                return Advice.REVERSE;
            }
        }
    }

    public boolean canOpenForIn(int nowFloor, int direction, int nowNum) {
        if (requestTable.getRequestMap().get(nowFloor).size() == 0) {
            //如果这层没人要上电梯
            return false;
        } else {
            //这层有人想上电梯
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
                //电梯向上运行
                if (nowNum == 6) {
                    return false;
                }
                if (upNum > 0) {
                    return true;
                } else {
                    return false;
                }
            } else {
                //电梯向下运行
                if (nowNum == 6) {
                    return false;
                }
                if (downNum > 0) {
                    return true;
                } else {
                    return false;
                }
            }
        }
    }

    public boolean canOpenForOut(HashMap<Integer, ArrayList<Person>> destMap, int nowFloor) {
        if (destMap.get(nowFloor).size() != 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean hasReqInOriginDirection(int direction, int nowFloor) {
        if (direction == 0) {
            //如果当前电梯向上
            int mark = 0;
            HashMap<Integer, ArrayList<Person>> tem = requestTable.getRequestMap();
            for (int key : tem.keySet()) {
                if (key > nowFloor && tem.get(key).size() != 0) {
                    mark = 1;
                    break;
                }
            }
            if (mark == 1) {
                return true;
            } else {
                return false;
            }
        } else {
            //如果当前电梯向下
            int mark = 0;
            HashMap<Integer, ArrayList<Person>> tem = requestTable.getRequestMap();
            for (int key : tem.keySet()) {
                if (key < nowFloor && tem.get(key).size() != 0) {
                    mark = 1;
                    break;
                }
            }
            if (mark == 1) {
                return true;
            } else {
                return false;
            }
        }
    }
}
