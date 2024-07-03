import com.oocourse.spec3.main.EmojiMessage;
import com.oocourse.spec3.main.Person;
import com.oocourse.spec3.main.Tag;

public class MyEmojiMessage implements EmojiMessage {
    private int id;
    private int emojiId;
    private int type;
    private Person person1;
    private Person person2;
    private Tag tag;
    private int socialValue;

    public MyEmojiMessage(int messageId, int emojiNumber,
                          Person messagePerson1, Person messagePerson2) {
        type = 0;
        tag = null;
        id = messageId;
        person1 = messagePerson1;
        person2 = messagePerson2;
        emojiId = emojiNumber;
    }

    public MyEmojiMessage(int messageId, int emojiNumber, Person messagePerson1, Tag messageTag) {
        type = 1;
        person2 = null;
        id = messageId;
        person1 = messagePerson1;
        tag = messageTag;
        emojiId = emojiNumber;
    }

    @Override
    public int getEmojiId() {
        return emojiId;
    }

    @Override
    public int getType() {
        return type;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public int getSocialValue() {
        socialValue = emojiId;
        return socialValue;
    }

    @Override
    public Person getPerson1() {
        return person1;
    }

    @Override
    public Person getPerson2() {
        return person2;
    }

    @Override
    public Tag getTag() {
        return tag;
    }
}
