import com.oocourse.spec3.exceptions.EqualTagIdException;

public class MyEqualTagIdException extends EqualTagIdException {
    private static int id;
    private static Counter counter = new Counter();

    public MyEqualTagIdException(int id) {
        this.id = id;
        counter.addCount(id);
    }

    @Override
    public void print() {
        System.out.println("eti-" + counter.getSum() + ", " + id + "-" + counter.getIdCount(id));
    }
}
