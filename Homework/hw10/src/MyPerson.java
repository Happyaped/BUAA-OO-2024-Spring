
import com.oocourse.spec2.main.Person;
import com.oocourse.spec2.main.Tag;

import java.util.HashMap;

public class MyPerson implements Person {
    private int id;
    private String name;
    private int age;
    private HashMap<Integer, Person> acquaintance;//person的id是key,Person是value
    private HashMap<Integer, Integer> value;//person的id是key，value是value
    private HashMap<Integer, Tag> tags;//tag的id是key，value是Tag

    public MyPerson(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
        acquaintance = new HashMap<>();
        value = new HashMap<>();
        tags = new HashMap<>();
    }

    public boolean strictEquals(Person person) {
        return true;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public boolean containsTag(int id) {
        return tags.containsKey(id);
    }

    @Override
    public Tag getTag(int id) {
        if (containsTag(id)) {
            return tags.get(id);
        } else {
            return null;
        }
    }

    @Override
    public void addTag(Tag tag) {
        if (!containsTag(tag.getId())) {
            tags.put(tag.getId(), tag);
        }
    }

    @Override
    public void delTag(int id) {
        if (containsTag(id)) {
            tags.remove(id);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Person)) {
            return false;
        }
        return (((Person) obj).getId() == id);
    }

    @Override
    public boolean isLinked(Person person) {
        if (acquaintance.containsKey(person.getId()) || person.getId() == id) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int queryValue(Person person) {
        if (acquaintance.containsKey(person.getId())) {
            return value.get(person.getId());
        } else {
            return 0;
        }
    }

    public void addAcquaintance(Person person) {
        acquaintance.put(person.getId(), person);
    }

    public void addValue(Person person, int personValue) {
        value.put(person.getId(), personValue);
    }

    public void changeValue(Person person, int personValue) {
        int tem = value.get(person.getId()) + personValue;
        value.remove(person.getId());
        value.put(person.getId(), tem);
    }

    public void deleteAcquaintance(Person person) {
        acquaintance.remove(person.getId());
    }

    public void deleteValue(Person person) {
        value.remove(person.getId());
    }

    public HashMap<Integer, Person> getAcquaintance() {
        return acquaintance;
    }

    public HashMap<Integer, Integer> getValue() {
        return value;
    }

    public void deleteTagPerson(Person person) {
        for (int key : tags.keySet()) {
            if (tags.get(key).hasPerson(person)) {
                tags.get(key).delPerson(person);
            }
        }
    }

    public int getBestFriendId(int preBestFriendId, int nowId) {
        if (preBestFriendId != id) {
            int tem1 = value.get(preBestFriendId);
            int tem2 = value.get(nowId);
            if (tem1 < tem2) {
                return nowId;
            } else if (tem1 == tem2) {
                if (nowId < preBestFriendId) {
                    return nowId;
                } else {
                    return preBestFriendId;
                }
            } else {
                return preBestFriendId;
            }
        } else {
            return nowId;
        }
    }

    public int changeGetBestFriendId(int preBestFriendId, int nowId) {
        if (preBestFriendId != nowId) {
            //改的id和原来的bestFriend不一样
            int tem1 = value.get(preBestFriendId);
            int tem2 = value.get(nowId);
            if (tem1 < tem2) {
                return nowId;
            } else if (tem1 == tem2) {
                if (nowId < preBestFriendId) {
                    return nowId;
                } else {
                    return preBestFriendId;
                }
            } else {
                return preBestFriendId;
            }
        } else {
            int maxValue = 0;
            int bestFriendId = 0;
            int flag = 0;
            for (int key : value.keySet()) {
                if (flag == 1) {
                    int tem = value.get(key);
                    if (maxValue < tem) {
                        maxValue = value.get(key);
                        bestFriendId = key;
                    } else if (maxValue == tem) {
                        if (key < bestFriendId) {
                            bestFriendId = key;
                        }
                    }
                } else {
                    bestFriendId = key;
                    maxValue = value.get(key);
                    flag = 1;
                }
            }
            return bestFriendId;
        }
    }

    public int delGetBestFriendId(int preBestFriendId) {
        if (acquaintance.containsKey(preBestFriendId)) {
            return preBestFriendId;
        } else {
            if (acquaintance.size() != 0) {
                int maxValue = 0;
                int bestFriendId = 0;
                int flag = 0;
                for (int key : value.keySet()) {
                    if (flag == 1) {
                        int tem = value.get(key);
                        if (maxValue < tem) {
                            maxValue = value.get(key);
                            bestFriendId = key;
                        } else if (maxValue == tem) {
                            if (key < bestFriendId) {
                                bestFriendId = key;
                            }
                        }
                    } else {
                        bestFriendId = key;
                        maxValue = value.get(key);
                        flag = 1;
                    }
                }
                return bestFriendId;
            } else {
                return id;
            }
        }
    }

    public HashMap<Integer, Tag> getTags() {
        return tags;
    }
}
