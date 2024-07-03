import com.oocourse.elevator1.TimableOutput;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        TimableOutput.initStartTimestamp();
        RequestTable mainRequestTable = new RequestTable();
        ArrayList<RequestTable> requestTables = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            RequestTable parallelRequestTable = new RequestTable();
            requestTables.add(parallelRequestTable);
            Elevator elevator = new Elevator(parallelRequestTable, i + 1);
            elevator.start();
        }
        Schedule schedule = new Schedule(mainRequestTable, requestTables);
        schedule.start();
        InputThread inputThread = new InputThread(mainRequestTable);
        inputThread.start();
    }
}
