import com.oocourse.spec3.exceptions.EmojiIdNotFoundException;

public class MyEmojiIdNotFoundException extends EmojiIdNotFoundException {
    private static int id;
    private static Counter counter = new Counter();

    public MyEmojiIdNotFoundException(int id) {
        this.id = id;
        counter.addCount(id);
    }

    @Override
    public void print() {
        System.out.println("einf-" + counter.getSum() + ", " + id + "-" + counter.getIdCount(id));
    }
}
