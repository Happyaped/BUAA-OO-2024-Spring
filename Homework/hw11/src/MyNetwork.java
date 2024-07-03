import com.oocourse.spec3.exceptions.AcquaintanceNotFoundException;
import com.oocourse.spec3.exceptions.EmojiIdNotFoundException;
import com.oocourse.spec3.exceptions.EqualEmojiIdException;
import com.oocourse.spec3.exceptions.EqualMessageIdException;
import com.oocourse.spec3.exceptions.EqualPersonIdException;
import com.oocourse.spec3.exceptions.EqualRelationException;
import com.oocourse.spec3.exceptions.EqualTagIdException;
import com.oocourse.spec3.exceptions.MessageIdNotFoundException;
import com.oocourse.spec3.exceptions.PathNotFoundException;
import com.oocourse.spec3.exceptions.PersonIdNotFoundException;
import com.oocourse.spec3.exceptions.RelationNotFoundException;
import com.oocourse.spec3.exceptions.TagIdNotFoundException;
import com.oocourse.spec3.main.EmojiMessage;
import com.oocourse.spec3.main.Message;
import com.oocourse.spec3.main.Network;
import com.oocourse.spec3.main.Person;
import com.oocourse.spec3.main.RedEnvelopeMessage;
import com.oocourse.spec3.main.Tag;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.HashSet;

public class MyNetwork implements Network {
    private HashMap<Integer, Person> persons;//id是key，person是value，代表了所有人
    private HashMap<Integer, Message> messages;
    private HashSet<Integer> emojiIdList;//存的是可以使用的id
    private HashMap<Integer, Integer> emojiHeatList;//key是emojiId,value代表热度
    private HashMap<Integer, Integer> bestFriends;//最好朋友
    private HashMap<Integer, HashMap<Integer, Integer>> maintainIdMap;
    private Boolean isDirty;//维护dijkstra是否脏了
    private DisjointSet disjointSet;//并查集
    private int blockSum;//代表block数量
    private int triSum;//代表tri数量
    private Dijkstra dijkstra1;
    private Maintain maintain;

    public MyNetwork() {
        persons = new HashMap<>();
        bestFriends = new HashMap<>();
        maintainIdMap = new HashMap<>();
        isDirty = false;
        disjointSet = new DisjointSet();
        blockSum = 0;
        triSum = 0;
        messages = new HashMap<>();
        emojiIdList = new HashSet<>();
        emojiHeatList = new HashMap<>();
        dijkstra1 = new Dijkstra();
        maintain = new Maintain();
    }

    public Message[] getMessages() {  return null;    }

    public int[] getEmojiIdList() {  return null;    }

    public int[] getEmojiHeatList() {  return null;    }

    @Override
    public boolean containsPerson(int id) {
        return persons.containsKey(id);
    }

    @Override
    public Person getPerson(int id) { if (persons.containsKey(id)) {
            return persons.get(id);  } else {
            return null; }  }

    @Override
    public void addPerson(Person person) throws EqualPersonIdException {
        if (!persons.containsKey(person.getId())) {
            persons.put(person.getId(), person);
            disjointSet.add(person.getId());
            blockSum++;
            bestFriends.put(person.getId(), person.getId()); } else {
            throw new MyEqualPersonIdException(person.getId()); }  }

    @Override
    public void addRelation(int id1, int id2, int value) throws
            PersonIdNotFoundException, EqualRelationException {
        int mark = 0;
        Person temPerson1;
        Person temPerson2; if (persons.containsKey(id1) && persons.containsKey(id2)) {
            mark = 1;
            temPerson1 = persons.get(id1);
            temPerson2 = persons.get(id2); if (!temPerson1.isLinked(temPerson2)) {
                mark = 2; if (temPerson1 instanceof MyPerson && temPerson2 instanceof MyPerson) {
                    for (int key : persons.keySet()) { if (key == id1 || key == id2) { continue;   }
                        if (temPerson1.isLinked(persons.get(key)) &&
                                temPerson2.isLinked(persons.get(key))) {    triSum++;   }   }
                    maintain.maintainAddRelationSum(id1, id2, value,persons);
                    ((MyPerson) temPerson1).addAcquaintance(temPerson2);
                    ((MyPerson) temPerson1).addValue(temPerson2, value);
                    ((MyPerson) temPerson2).addAcquaintance(temPerson1);
                    ((MyPerson) temPerson2).addValue(temPerson1, value);
                    int preId1 = bestFriends.get(id1);
                    int preId2 = bestFriends.get(id2);
                    bestFriends.put(id1, ((MyPerson) temPerson1).getBestFriendId(preId1, id2));
                    bestFriends.put(id2, ((MyPerson) temPerson2).getBestFriendId(preId2, id1));
                    if (disjointSet.find(id1) != disjointSet.find(id2)) {
                        blockSum--;    }
                    disjointSet.merge(id1, id2);
                    isDirty = true; } } } if (mark == 1) {
            throw new MyEqualRelationException(id1, id2); } else if (mark == 0) {
            if (!persons.containsKey(id1)) {
                throw new MyPersonIdNotFoundException(id1); } else {
                throw new MyPersonIdNotFoundException(id2); } }  }

    @Override
    public void modifyRelation(int id1, int id2, int value) throws
            PersonIdNotFoundException, EqualPersonIdException,
            MyRelationNotFoundException {
        int mark = 0;
        Person temPerson1;
        Person temPerson2; if (persons.containsKey(id1) && persons.containsKey(id2)) {
            mark = 1;   if (id1 != id2) {
                mark = 2;
                temPerson1 = persons.get(id1);
                temPerson2 = persons.get(id2);  if (temPerson1.isLinked(temPerson2)) {
                    mark = 3;
                    if (temPerson1.queryValue(temPerson2) + value > 0) {
                        if (temPerson1 instanceof MyPerson && temPerson2 instanceof MyPerson) {
                            maintain.maintainModifyRelationSum(id1, id2, value,persons);
                            ((MyPerson) temPerson1).changeValue(temPerson2, value);
                            ((MyPerson) temPerson2).changeValue(temPerson1, value);
                            int preId1 = bestFriends.get(id1);
                            int preId2 = bestFriends.get(id2);
                            bestFriends.put(id1, ((MyPerson) temPerson1).
                                    changeGetBestFriendId(preId1, id2));
                            bestFriends.put(id2, ((MyPerson) temPerson2).
                                    changeGetBestFriendId(preId2, id1)); } } else {
                        if (temPerson1 instanceof MyPerson && temPerson2 instanceof MyPerson) {
                            for (int key : persons.keySet()) {  if (key == id1 || key == id2) {
                                    continue; } if (temPerson1.isLinked(persons.get(key)) &&
                                        temPerson2.isLinked(persons.get(key))) {
                                    triSum--;      } }
                            maintain.maintainDelRelationSum(id1, id2,
                                    temPerson1.queryValue(temPerson2),persons);
                            ((MyPerson) temPerson1).deleteAcquaintance(temPerson2);
                            ((MyPerson) temPerson1).deleteValue(temPerson2);
                            ((MyPerson) temPerson2).deleteAcquaintance(temPerson1);
                            ((MyPerson) temPerson2).deleteValue(temPerson1);
                            ((MyPerson) temPerson1).deleteTagPerson(temPerson2);
                            ((MyPerson) temPerson2).deleteTagPerson(temPerson1);
                            int preId1 = bestFriends.get(id1);
                            int preId2 = bestFriends.get(id2);
                            bestFriends.put(id1, ((MyPerson) temPerson1).
                                    delGetBestFriendId(preId1));
                            bestFriends.put(id2, ((MyPerson) temPerson2).
                                    delGetBestFriendId(preId2));
                            disjointSet.delete(persons);
                            if (disjointSet.find(id1) != disjointSet.find(id2)) {
                                blockSum++;   }
                            isDirty = true;  }  } } } } if (mark == 0) {
            if (!persons.containsKey(id1)) {
                throw new MyPersonIdNotFoundException(id1); } else {
                throw new MyPersonIdNotFoundException(id2); } } else if (mark == 1) {
            throw new MyEqualPersonIdException(id1); } else if (mark == 2) {
            throw new MyRelationNotFoundException(id1, id2); }  }

    @Override
    public int queryValue(int id1, int id2) throws
            PersonIdNotFoundException, RelationNotFoundException {
        int mark = 0;
        Person temPerson1;
        Person temPerson2; if (persons.containsKey(id1) && persons.containsKey(id2)) {
            mark = 1;
            temPerson1 = persons.get(id1);
            temPerson2 = persons.get(id2); if (temPerson1.isLinked(temPerson2)) {
                mark = 2;
                return temPerson1.queryValue(temPerson2); }  } if (mark == 0) {
            if (!persons.containsKey(id1)) {
                throw new MyPersonIdNotFoundException(id1); } else {
                throw new MyPersonIdNotFoundException(id2); } } else if (mark == 1) {
            throw new MyRelationNotFoundException(id1, id2); }
        return 0; }

    @Override
    public boolean isCircle(int id1, int id2) throws PersonIdNotFoundException {
        if (persons.containsKey(id1) && persons.containsKey(id2)) {
            return disjointSet.find(id1) == disjointSet.find(id2);  } else {
            if (!persons.containsKey(id1)) {
                throw new MyPersonIdNotFoundException(id1);
            } else {
                throw new MyPersonIdNotFoundException(id2); } } }

    @Override
    public int queryBlockSum() {
        return blockSum;
    }

    @Override
    public int queryTripleSum() {
        return triSum;
    }

    @Override
    public void addTag(int personId, Tag tag) throws
            PersonIdNotFoundException, EqualTagIdException {
        int mark = 0;  if (containsPerson(personId)) {
            mark = 1;
            if (!getPerson(personId).containsTag(tag.getId())) {
                mark = 2;
                getPerson(personId).addTag(tag); } }  if (mark == 0) {
            throw new MyPersonIdNotFoundException(personId); } else if (mark == 1) {
            throw new MyEqualTagIdException(tag.getId()); }  }

    @Override
    public void addPersonToTag(int personId1, int personId2, int tagId) throws
            PersonIdNotFoundException, RelationNotFoundException,
            TagIdNotFoundException, EqualPersonIdException {
        int mark = 0;
        MyTag tag;
        if (containsPerson(personId1) && containsPerson(personId2) && personId1 != personId2) {
            mark = 2; if (getPerson(personId2).isLinked(getPerson(personId1))) {
                mark = 3;  if (getPerson(personId2).containsTag(tagId)) {
                    mark = 4;
                    if (!getPerson(personId2).getTag(tagId).hasPerson(getPerson(personId1))) {
                        mark = 5;
                        tag = (MyTag) getPerson(personId2).getTag(tagId);
                        HashMap<Integer, Person> tem = tag.getPersons(); if (tem.size() <= 1111) {
                            tag.addPerson(getPerson(personId1)); } } } } } if (mark == 0) {
            if (!persons.containsKey(personId1)) {
                throw new MyPersonIdNotFoundException(personId1);
            } else if (!persons.containsKey(personId2)) {
                throw new MyPersonIdNotFoundException(personId2);  } else {
                throw new MyEqualPersonIdException(personId1); } } else if (mark == 2) {
            throw new MyRelationNotFoundException(personId1, personId2);  } else if (mark == 3) {
            throw new MyTagIdNotFoundException(tagId);  } else if (mark == 4) {
            throw new MyEqualPersonIdException(personId1); }  }

    @Override
    public int queryTagValueSum(int personId, int tagId) throws
            PersonIdNotFoundException, TagIdNotFoundException {
        int mark = 0; if (containsPerson(personId)) {
            mark = 1; if (getPerson(personId).containsTag(tagId)) {
                mark = 2;
                return getPerson(personId).getTag(tagId).getValueSum(); } } if (mark == 0) {
            throw new MyPersonIdNotFoundException(personId); } else if (mark == 1) {
            throw new MyTagIdNotFoundException(tagId); }
        return 0; }

    @Override
    public int queryTagAgeVar(int personId, int tagId) throws
            PersonIdNotFoundException, TagIdNotFoundException {
        int mark = 0; if (containsPerson(personId)) {
            mark = 1;  if (getPerson(personId).containsTag(tagId)) {
                mark = 2;
                return getPerson(personId).getTag(tagId).getAgeVar(); } } if (mark == 0) {
            throw new MyPersonIdNotFoundException(personId); } else if (mark == 1) {
            throw new MyTagIdNotFoundException(tagId); }
        return 0; }

    @Override
    public void delPersonFromTag(int personId1, int personId2, int tagId)
            throws PersonIdNotFoundException, TagIdNotFoundException {
        int mark = 0;
        Tag tag; if (containsPerson(personId1) && containsPerson(personId2)) {
            mark = 1; if (getPerson(personId2).containsTag(tagId)) {
                mark = 2; if (getPerson(personId2).getTag(tagId).hasPerson(getPerson(personId1))) {
                    mark = 3;
                    tag = getPerson(personId2).getTag(tagId);
                    tag.delPerson(getPerson(personId1)); } } }  if (mark == 0) {
            if (!persons.containsKey(personId1)) {
                throw new MyPersonIdNotFoundException(personId1);  } else {
                throw new MyPersonIdNotFoundException(personId2);  } } else if (mark == 1) {
            throw new MyTagIdNotFoundException(tagId); } else if (mark == 2) {
            throw new MyPersonIdNotFoundException(personId1); }  }

    @Override
    public void delTag(int personId, int tagId) throws
            PersonIdNotFoundException, TagIdNotFoundException {
        int mark = 0; if (containsPerson(personId)) {
            mark = 1;  if (getPerson(personId).containsTag(tagId)) {
                mark = 2;
                getPerson(personId).delTag(tagId); } } if (mark == 0) {
            throw new MyPersonIdNotFoundException(personId); } else if (mark == 1) {
            throw new MyTagIdNotFoundException(tagId); } }

    @Override
    public boolean containsMessage(int id) {
        return messages.containsKey(id);
    }

    @Override
    public void addMessage(Message message) throws EqualMessageIdException,
            EmojiIdNotFoundException, EqualPersonIdException {
        int mark = 0;
        int tem = 0;
        int tem1 = 0; if (!containsMessage(message.getId())) {
            mark = 1;  if (message instanceof MyEmojiMessage) {
                tem = ((EmojiMessage) message).getEmojiId();
                if (containsEmojiId(((MyEmojiMessage) message).getEmojiId())) {
                    mark = 2;
                    tem1 = message.getPerson1().getId();  if (message.getType() == 0 &&
                            !message.getPerson1().equals(message.getPerson2())) {
                        mark = 3;
                        messages.put(message.getId(), message); } else if (message.getType() != 0) {
                        mark = 3;
                        messages.put(message.getId(), message); } } } else {
                mark = 2;
                tem1 = message.getPerson1().getId();  if (message.getType() == 0 &&
                        !message.getPerson1().equals(message.getPerson2())) {
                    mark = 3;
                    messages.put(message.getId(), message); } else if (message.getType() != 0) {
                    mark = 3;
                    messages.put(message.getId(), message); }         } } if (mark == 0) {
            throw new MyEqualMessageIdException(message.getId()); } else if (mark == 1) {
            throw new MyEmojiIdNotFoundException(tem); } else if (mark == 2) {
            throw new MyEqualPersonIdException(tem1); } }

    @Override
    public Message getMessage(int id) {  if (containsMessage(id)) {
            return messages.get(id); } else {
            return null; } }

    @Override
    public void sendMessage(int id) throws RelationNotFoundException, MessageIdNotFoundException,
            TagIdNotFoundException {
        int mark = 0;
        int id1 = 0;
        int id2 = 0;
        int id3 = 0;   if (containsMessage(id)) {
            mark = 1;  if (getMessage(id).getType() == 0) {
                id1 = getMessage(id).getPerson1().getId();
                id2 = getMessage(id).getPerson2().getId();
                if (getMessage(id).getPerson1().isLinked(getMessage(id).getPerson2())) {
                    mark = 2;
                    Message temMessage = messages.get(id);
                    messages.remove(id);
                    Person temPerson1 = temMessage.getPerson1();
                    Person temPerson2 = temMessage.getPerson2();
                    temPerson1.addSocialValue(temMessage.getSocialValue());
                    temPerson2.addSocialValue(temMessage.getSocialValue());
                    if (temMessage instanceof MyRedEnvelopeMessage) {
                        int temMoney = ((RedEnvelopeMessage) temMessage).getMoney();
                        temPerson1.addMoney(-temMoney);
                        temPerson2.addMoney(temMoney);
                    } else if (temMessage instanceof MyEmojiMessage) {
                        int temNum = emojiHeatList.get(((MyEmojiMessage)
                                temMessage).getEmojiId()) + 1;
                        emojiHeatList.put(((MyEmojiMessage) temMessage).getEmojiId(), temNum);  }
                    List<Message> temSet = temPerson2.getMessages();
                    temSet.add(0, temMessage);   } } else if (getMessage(id).getType() == 1) {
                id3 = getMessage(id).getTag().getId();
                if (getMessage(id).getPerson1().containsTag(getMessage(id).getTag().getId())) {
                    mark = 3;
                    Message temMessage = messages.get(id);
                    messages.remove(id);
                    Person temPerson1 = temMessage.getPerson1();
                    temPerson1.addSocialValue(temMessage.getSocialValue());
                    MyTag temTag = (MyTag) temMessage.getTag();
                    HashMap<Integer, Person> temPersons = temTag.getPersons();
                    int temValue = temMessage.getSocialValue();
                    int temSize = temTag.getSize();
                    for (int key : temPersons.keySet()) {
                        temPersons.get(key).addSocialValue(temValue);   }
                    if (temMessage instanceof MyRedEnvelopeMessage && temSize > 0) {
                        int i = ((MyRedEnvelopeMessage) temMessage).getMoney() / temSize;
                        temPerson1.addMoney(-i * temSize);
                        for (int key : temPersons.keySet()) {
                            temPersons.get(key).addMoney(i);  }
                    } else if (temMessage instanceof MyEmojiMessage) {
                        int temNum = emojiHeatList.get(((MyEmojiMessage) temMessage).
                                getEmojiId()) + 1;
                        emojiHeatList.put(((MyEmojiMessage) temMessage).getEmojiId(), temNum); } }
            } }
        if (mark == 0) {
            throw new MyMessageIdNotFoundException(id);  } else if (mark == 1) {
            if (getMessage(id).getType() == 0) {
                throw new MyRelationNotFoundException(id1, id2); } else {
                throw new MyTagIdNotFoundException(id3); } }  }

    @Override
    public int querySocialValue(int id) throws PersonIdNotFoundException {
        int mark = 0;  if (containsPerson(id)) {
            mark = 1;
            return getPerson(id).getSocialValue();  }  if (mark == 0) {
            throw new MyPersonIdNotFoundException(id);   }
        return 0;  }

    @Override
    public List<Message> queryReceivedMessages(int id) throws PersonIdNotFoundException {
        int mark = 0;  if (containsPerson(id)) {
            mark = 1;
            return getPerson(id).getReceivedMessages();  } if (mark == 0) {
            throw new MyPersonIdNotFoundException(id); }
        return null;  }

    @Override
    public boolean containsEmojiId(int id) {
        return emojiIdList.contains(id);
    }

    @Override
    public void storeEmojiId(int id) throws EqualEmojiIdException {
        int mark = 0;  if (!containsEmojiId(id)) {
            mark = 1;
            emojiIdList.add(id);
            emojiHeatList.put(id, 0);  }  if (mark == 0) {
            throw new MyEqualEmojiIdException(id);  }  }

    @Override
    public int queryMoney(int id) throws PersonIdNotFoundException {
        int mark = 0;  if (containsPerson(id)) {
            mark = 1;
            return getPerson(id).getMoney();  } if (mark == 0) {
            throw new MyPersonIdNotFoundException(id);  }
        return 0;    }

    @Override
    public int queryPopularity(int id) throws EmojiIdNotFoundException {
        int mark = 0;   if (containsEmojiId(id)) {
            mark = 1;
            return emojiHeatList.get(id); } if (mark == 0) {
            throw new MyEmojiIdNotFoundException(id);  }
        return 0;   }

    @Override
    public int deleteColdEmoji(int limit) {
        Iterator<Integer> iterator = emojiIdList.iterator();
        while (iterator.hasNext()) {
            int key1 = iterator.next();
            if (emojiHeatList.get(key1) < limit) {
                iterator.remove();
                emojiHeatList.remove(key1); } }
        HashMap<Integer, Message> newMessages = new HashMap<>();
        for (int key : messages.keySet()) {
            if (messages.get(key) instanceof MyEmojiMessage) {
                int temId = ((MyEmojiMessage) messages.get(key)).getEmojiId();
                if (containsEmojiId(temId)) {
                    newMessages.put(key, messages.get(key)); } } else {
                newMessages.put(key, messages.get(key)); }  }
        messages = newMessages;
        return emojiIdList.size();
    }

    @Override
    public void clearNotices(int personId) throws PersonIdNotFoundException {
        int mark = 0;
        if (containsPerson(personId)) {
            mark = 1;
            MyPerson temPerson = (MyPerson) persons.get(personId);
            List<Message> temMessages = temPerson.getMessages();
            List<Message> newMessages = new ArrayList<>();
            for (int i = 0; i < temMessages.size(); i++) {
                if (!(temMessages.get(i) instanceof MyNoticeMessage)) {
                    newMessages.add(temMessages.get(i));  } }
            temPerson.setMessages(newMessages);  }
        if (mark == 0) {
            throw new MyPersonIdNotFoundException(personId); }  }

    @Override
    public int queryBestAcquaintance(int id) throws
            PersonIdNotFoundException, AcquaintanceNotFoundException {
        int mark = 0;
        MyPerson temPerson;   if (containsPerson(id)) {
            mark = 1;
            temPerson = (MyPerson) getPerson(id);
            if (temPerson.getAcquaintance().size() != 0) {
                mark = 2;
                return bestFriends.get(id);  }  }   if (mark == 0) {
            throw new MyPersonIdNotFoundException(id);  } else if (mark == 1) {
            throw new MyAcquaintanceNotFoundException(id);  }
        return 0;  }

    @Override
    public int queryCoupleSum() {
        int sum = 0;
        for (int key : bestFriends.keySet()) {
            int tem1 = bestFriends.get(key);
            int tem2 = bestFriends.get(tem1); if (tem1 != key && tem2 == key) {
                sum++;  }  }
        return sum / 2;  }

    @Override
    public int queryShortestPath(int id1, int id2) throws
            PersonIdNotFoundException, PathNotFoundException {
        int mark = 0; if (containsPerson(id1) && containsPerson(id2)) {
            mark = 1;  if (isCircle(id1, id2)) {
                mark = 2;   if (id1 == id2) {
                    return 0;    }   if (isDirty == true) {
                    maintainIdMap.clear();
                    HashMap<Integer, Integer> tem = dijkstra1.dijkstra(id1,persons,maintainIdMap);
                    isDirty = false;
                    return tem.get(id2) - 1; } else { if (maintainIdMap.containsKey(id1)) {
                        HashMap<Integer, Integer> tem = maintainIdMap.get(id1);
                        return tem.get(id2) - 1;  } else if (maintainIdMap.containsKey(id2)) {
                        HashMap<Integer, Integer> tem = maintainIdMap.get(id2);
                        return tem.get(id1) - 1;     } else {
                        HashMap<Integer, Integer> tem = dijkstra1.dijkstra(id1,
                                persons,maintainIdMap);
                        return tem.get(id2) - 1; } } } }
        if (mark == 0) { if (!persons.containsKey(id1)) {
                throw new MyPersonIdNotFoundException(id1); } else {
                throw new MyPersonIdNotFoundException(id2); } } else if (mark == 1) {
            throw new MyPathNotFoundException(id1, id2); }
        return 0;  } }
