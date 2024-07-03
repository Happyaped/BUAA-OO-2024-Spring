import com.oocourse.spec3.exceptions.PathNotFoundException;

public class MyPathNotFoundException extends PathNotFoundException {
    private static int id1;
    private static int id2;
    private static Counter counter = new Counter();

    public MyPathNotFoundException(int id1, int id2) {
        this.id1 = id1;
        this.id2 = id2;
        counter.addDoubleCount(id1, id2);
    }

    @Override
    public void print() {
        if (id1 < id2) {
            System.out.println("pnf-" + counter.getSum() + ", " + id1 +
                    "-" + counter.getIdCount(id1) + ", " + id2 + "-" + counter.getIdCount(id2));
        } else {
            System.out.println("pnf-" + counter.getSum() + ", " + id2 +
                    "-" + counter.getIdCount(id2) + ", " + id1 + "-" + counter.getIdCount(id1));
        }
    }
}
