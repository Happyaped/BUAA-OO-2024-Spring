import com.oocourse.elevator3.DoubleCarResetRequest;
import com.oocourse.elevator3.ElevatorInput;
import com.oocourse.elevator3.NormalResetRequest;
import com.oocourse.elevator3.PersonRequest;
import com.oocourse.elevator3.Request;
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
                    } else if (request instanceof NormalResetRequest) {
                        //如果是电梯重置请求
                        schedule.resetElevator(((NormalResetRequest) request).getElevatorId(),
                                ((NormalResetRequest) request).getCapacity(),
                                ((NormalResetRequest) request).getSpeed());
                    } else if (request instanceof DoubleCarResetRequest) {
                        //第二种重置请求
                        schedule.doubleResetElevator(
                                ((DoubleCarResetRequest) request).getElevatorId(),
                                ((DoubleCarResetRequest) request).getCapacity(),
                                ((DoubleCarResetRequest) request).getSpeed(),
                                ((DoubleCarResetRequest) request).getTransferFloor());
                    }
                }
            }
            elevatorInput.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
