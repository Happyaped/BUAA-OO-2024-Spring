import com.oocourse.elevator3.TimableOutput;

public class Main {
    public static void main(String[] args) {
        TimableOutput.initStartTimestamp();
        InputThread inputThread = new InputThread();
        inputThread.start();
    }
}
