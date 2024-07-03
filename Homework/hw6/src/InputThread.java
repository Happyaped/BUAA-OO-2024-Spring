import com.oocourse.elevator2.ElevatorInput;
import com.oocourse.elevator2.PersonRequest;
import com.oocourse.elevator2.Request;
import com.oocourse.elevator2.ResetRequest;

import java.io.IOException;

public class InputThread extends Thread {
    private RequestTable mainRequestTable;
    private Schedule schedule;

    public InputThread() {
        this.mainRequestTable = new RequestTable();
        this.schedule = new Schedule(this.mainRequestTable);
        this.schedule.start();
    }

    @Override
    public void run() {
        try {
            ElevatorInput elevatorInput = new ElevatorInput(System.in);
            while (true) {
                Request request = elevatorInput.nextRequest();
                if (request == null) {
                    mainRequestTable.setEnd(true);
                    break;
                } else {
                    if (request instanceof PersonRequest) {
                        //如果是正常请求
                        Person person = new Person(((PersonRequest) request).getPersonId(),
                                ((PersonRequest) request).getFromFloor(),
                                ((PersonRequest) request).getToFloor());
                        mainRequestTable.addRequestMap(person);
                    } else if (request instanceof ResetRequest) {
                        //如果是电梯重置请求
                        schedule.resetElevator(((ResetRequest) request).getElevatorId(),
                                ((ResetRequest) request).getCapacity(),
                                ((ResetRequest) request).getSpeed());
                    }
                }
            }
            elevatorInput.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
