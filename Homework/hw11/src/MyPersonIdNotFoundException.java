
import com.oocourse.spec3.exceptions.PersonIdNotFoundException;

public class MyPersonIdNotFoundException extends PersonIdNotFoundException {
    private static int id;
    private static Counter counter = new Counter();

    public MyPersonIdNotFoundException(int id) {
        this.id = id;
        counter.addCount(id);

    }

    @Override
    public void print() {
        System.out.println("pinf-" + counter.getSum() + ", " + id + "-" + counter.getIdCount(id));
    }
}
