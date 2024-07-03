import com.oocourse.elevator3.TimableOutput;

import java.util.ArrayList;

public class Schedule extends Thread {
    private RequestTable mainRequestTable;//与InputThread共享
    private ArrayList<RequestTable> requestTables;//与Elevator共享
    private ArrayList<Elevator> elevators;//电梯表，可增加
    private Integer sum;//代表总的

    public Schedule(RequestTable mainRequestTable) {
        this.mainRequestTable = mainRequestTable;
        this.requestTables = new ArrayList<>();
        this.elevators = new ArrayList<>();
        this.sum = 0;
        for (int i = 0; i < 6; i++) {
            RequestTable parallelRequestTable = new RequestTable();
            requestTables.add(parallelRequestTable);
            Elevator elevator = new Elevator(parallelRequestTable, i + 1, mainRequestTable);
            elevators.add(elevator);
            elevator.start();
        }
    }

    @Override
    public void run() {
        while (true) {
            if (mainRequestTable.isEmpty() && mainRequestTable.isEnd()) {
                int flag = 0;
                for (Elevator item : elevators) {
                    if (item.getResetFlag() == true || item.getDoubleResetFlag() == true) {
                        flag = 1;
                        break;                    }
                }
                if (flag == 0) {
                    for (int i = 0; i < requestTables.size(); i++) {
                        requestTables.get(i).setEnd(true);                    }
                    return;                } else if (flag == 1) {
                    synchronized (mainRequestTable) {
                        try {
                            mainRequestTable.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();                        }
                    }
                }
            }
            if (mainRequestTable.isEmpty() && !mainRequestTable.isEnd()) {
                synchronized (mainRequestTable) {
                    try {
                        mainRequestTable.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();                    }
                }
            }
            Person person = mainRequestTable.getOnePersonAndRemove();
            if (person == null) {
                continue;            }
            int sumMark = 0;
            for (Elevator item : elevators) {
                if (item.getResetFlag() == true || item.getDoubleResetFlag() == true) {
                    sumMark++;
                }
            }
            if (sumMark == 5) {
                try {
                    sleep(1200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            int elevatorIn = sum % 6;
            while (elevators.get(elevatorIn).getResetFlag() == true ||
                    elevators.get(elevatorIn).getDoubleResetFlag() == true) {
                sum++;
                elevatorIn = sum % 6;
            }
            requestTables.get(elevatorIn).addRequestMap(person);
            int mark = elevators.get(elevatorIn).getMarkDouble();
            int realElevator = elevatorIn + 1;
            if (mark == 0) {
                TimableOutput.println("RECEIVE-" + person.getId() + "-" + realElevator);
            }
            sum++;
        }
    }

    public synchronized void resetElevator(int idElevator, int resetCapacity, double moveTime) {
        //把相应电梯的resetFlag设为true
        Elevator elevator = elevators.get(idElevator - 1);
        elevator.setResetFlag(true);
        //传入修改后的容量和速度
        elevator.setResetCapacity(resetCapacity);
        elevator.setResetMoveTime((int) (moveTime * 1000));
    }

    public synchronized void doubleResetElevator(int idElevator, int resetCapacity,
                                                 double moveTime, int changeFloor) {
        Elevator elevator = elevators.get(idElevator - 1);
        elevator.setDoubleResetFlag(true);
        elevator.setResetCapacity(resetCapacity);
        elevator.setResetMoveTime((int) (moveTime * 1000));
        elevator.setResetChangeFloor(changeFloor);
    }
}
