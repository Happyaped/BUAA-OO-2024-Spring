
import com.oocourse.spec1.main.Person;

import java.util.HashMap;

public class MyPerson implements Person {
    private int id;
    private String name;
    private int age;
    private HashMap<Integer, Person> acquaintance;//id是key,Person是value
    private HashMap<Integer, Integer> value;//id是key，value是value

    public MyPerson(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
        acquaintance = new HashMap<>();
        value = new HashMap<>();

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
}
