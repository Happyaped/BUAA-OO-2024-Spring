import com.oocourse.spec3.main.NoticeMessage;
import com.oocourse.spec3.main.Person;
import com.oocourse.spec3.main.Tag;

public class MyNoticeMessage implements NoticeMessage {
    private int type;
    private Tag tag;
    private int id;
    private Person person1;
    private Person person2;
    private String string;
    private int socialValue;

    public MyNoticeMessage(int messageId, String noticeString,
                           Person messagePerson1, Person messagePerson2) {
        type = 0;
        tag = null;
        id = messageId;
        person1 = messagePerson1;
        person2 = messagePerson2;
        string = noticeString;
    }

    public MyNoticeMessage(int messageId, String noticeString,
                           Person messagePerson1, Tag messageTag) {
        type = 1;
        person2 = null;
        id = messageId;
        person1 = messagePerson1;
        tag = messageTag;
        string = noticeString;
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
        socialValue = string.length();
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

    @Override
    public String getString() {
        return string;
    }
}
