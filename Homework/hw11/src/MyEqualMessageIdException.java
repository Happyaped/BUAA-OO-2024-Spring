import com.oocourse.spec3.exceptions.EqualMessageIdException;

public class MyEqualMessageIdException extends EqualMessageIdException {
    private static int id;
    private static Counter counter = new Counter();

    public MyEqualMessageIdException(int id) {
        this.id = id;
        counter.addCount(id);
    }

    @Override
    public void print() {
        System.out.println("emi-" + counter.getSum() + ", " + id + "-" + counter.getIdCount(id));
    }
}
