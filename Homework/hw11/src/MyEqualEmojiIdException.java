import com.oocourse.spec3.exceptions.EqualEmojiIdException;

public class MyEqualEmojiIdException extends EqualEmojiIdException {
    private static int id;
    private static Counter counter = new Counter();

    public MyEqualEmojiIdException(int id) {
        this.id = id;
        counter.addCount(id);
    }

    @Override
    public void print() {
        System.out.println("eei-" + counter.getSum() + ", " + id + "-" + counter.getIdCount(id));
    }
}
