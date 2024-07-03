import com.oocourse.spec3.exceptions.TagIdNotFoundException;

public class MyTagIdNotFoundException extends TagIdNotFoundException {
    private static int id;
    private static Counter counter = new Counter();

    public MyTagIdNotFoundException(int id) {
        this.id = id;
        counter.addCount(id);
    }

    @Override
    public void print() {
        System.out.println("tinf-" + counter.getSum() + ", " + id + "-" + counter.getIdCount(id));
    }
}
