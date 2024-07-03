import com.oocourse.elevator2.TimableOutput;

public class Main {
    public static void main(String[] args) {
        TimableOutput.initStartTimestamp();
        InputThread inputThread = new InputThread();
        inputThread.start();
    }
}
