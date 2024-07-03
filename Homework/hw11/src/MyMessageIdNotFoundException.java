import com.oocourse.spec3.exceptions.MessageIdNotFoundException;

public class MyMessageIdNotFoundException extends MessageIdNotFoundException {
    private static int id;
    private static Counter counter = new Counter();

    public MyMessageIdNotFoundException(int id) {
        this.id = id;
        counter.addCount(id);
    }

    @Override
    public void print() {
        System.out.println("minf-" + counter.getSum() + ", " + id + "-" + counter.getIdCount(id));
    }
}
