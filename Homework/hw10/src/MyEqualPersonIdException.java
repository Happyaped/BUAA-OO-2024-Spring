import com.oocourse.spec2.exceptions.EqualPersonIdException;

public class MyEqualPersonIdException extends EqualPersonIdException {
    private static int id;
    private static Counter counter = new Counter();

    public MyEqualPersonIdException(int id) {
        this.id = id;
        counter.addCount(id);

    }

    @Override
    public void print() {
        System.out.println("epi-" + counter.getSum() + ", " + id + "-" + counter.getIdCount(id));
    }
}
