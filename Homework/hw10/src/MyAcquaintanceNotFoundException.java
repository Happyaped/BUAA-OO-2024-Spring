import com.oocourse.spec2.exceptions.AcquaintanceNotFoundException;

public class MyAcquaintanceNotFoundException extends AcquaintanceNotFoundException {
    private static int id;
    private static Counter counter = new Counter();

    public MyAcquaintanceNotFoundException(int id) {
        this.id = id;
        counter.addCount(id);
    }

    @Override
    public void print() {
        System.out.println("anf-" + counter.getSum() + ", " + id + "-" + counter.getIdCount(id));
    }
}
