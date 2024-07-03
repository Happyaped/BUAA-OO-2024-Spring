import com.oocourse.elevator1.ElevatorInput;
import com.oocourse.elevator1.PersonRequest;

import java.io.IOException;

public class InputThread extends Thread {
    private RequestTable mainRequestTable;

    public InputThread(RequestTable mainRequestTable) {
        this.mainRequestTable = mainRequestTable;
    }

    @Override
    public void run() {
        try {
            ElevatorInput elevatorInput = new ElevatorInput(System.in);
            while (true) {
                PersonRequest request = elevatorInput.nextPersonRequest();
                //System.out.println("!!");
                if (request == null) {
                    mainRequestTable.setEnd(true);
                    //System.out.println("1");
                    break;
                } else {
                    Person person = new Person(request.getPersonId(),
                            request.getElevatorId(), request.getFromFloor(), request.getToFloor());
                    mainRequestTable.addRequestMap(person);
                }
            }
            elevatorInput.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
