import java.util.ArrayList;

public class Schedule extends Thread {
    private RequestTable mainRequestTable;//与InputThread共享
    private ArrayList<RequestTable> requestTables;//与Elevator共享

    //private HashMap<Integer,Elevator> elevatorMap;//电梯调度
    public Schedule(RequestTable mainRequestTable, ArrayList<RequestTable> requestTables) {
        this.mainRequestTable = mainRequestTable;
        this.requestTables = requestTables;
    }

    @Override
    public void run() {
        //第一次作业制定了电梯，不用进行调度
        while (true) {
            if (mainRequestTable.isEmpty() && mainRequestTable.isEnd()) {
                for (int i = 0; i < requestTables.size(); i++) {
                    requestTables.get(i).setEnd(true);
                    //System.out.println("2");
                }
                return;
            }
            if (mainRequestTable.isEmpty() && !mainRequestTable.isEnd()) {
                synchronized (mainRequestTable) {
                    try {
                        mainRequestTable.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            Person person = mainRequestTable.getOnePersonAndRemove();
            if (person == null) {
                continue;
            }
            if (person.getIdElevator() == 1) {
                requestTables.get(0).addRequestMap(person);
            } else if (person.getIdElevator() == 2) {
                requestTables.get(1).addRequestMap(person);
            } else if (person.getIdElevator() == 3) {
                requestTables.get(2).addRequestMap(person);
            } else if (person.getIdElevator() == 4) {
                requestTables.get(3).addRequestMap(person);
            } else if (person.getIdElevator() == 5) {
                requestTables.get(4).addRequestMap(person);
            } else {
                requestTables.get(5).addRequestMap(person);
            }
        }
    }
}
