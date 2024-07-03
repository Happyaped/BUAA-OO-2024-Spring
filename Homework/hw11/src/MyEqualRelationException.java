import com.oocourse.spec3.exceptions.EqualRelationException;

public class MyEqualRelationException extends EqualRelationException {
    private static int id1;
    private static int id2;
    private static Counter counter = new Counter();

    public MyEqualRelationException(int id1, int id2) {
        this.id1 = id1;
        this.id2 = id2;
        if (id1 != id2) {
            counter.addDoubleCount(id1, id2);
        } else {
            counter.addCount(id1);

        }
    }

    @Override
    public void print() {
        if (id1 < id2) {
            System.out.println("er-" + counter.getSum() + ", " + id1 + "-" +
                    counter.getIdCount(id1) + ", " + id2 + "-" + counter.getIdCount(id2));
        } else {
            System.out.println("er-" + counter.getSum() + ", " + id2 + "-" +
                    counter.getIdCount(id2) + ", " + id1 + "-" + counter.getIdCount(id1));
        }
    }
}
