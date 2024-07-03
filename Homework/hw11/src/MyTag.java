import com.oocourse.spec3.main.Person;
import com.oocourse.spec3.main.Tag;

import java.util.HashMap;

public class MyTag implements Tag {
    private int id;
    private HashMap<Integer, Person> persons;//person的id是key，person是value
    private int sum;//用于维护

    public MyTag(int id) {
        this.id = id;
        persons = new HashMap<>();
        sum = 0;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof Tag) {
            return (((Tag) obj).getId() == id);
        } else {
            return false;
        }
    }

    @Override
    public void addPerson(Person person) {
        if (!hasPerson(person)) {
            persons.put(person.getId(), person);
            for (int key : persons.keySet()) {
                if (person.isLinked(persons.get(key))) {
                    sum += 2 * person.queryValue(persons.get(key));
                }
            }
        }
    }

    @Override
    public boolean hasPerson(Person person) {
        return persons.containsKey(person.getId());
    }

    @Override
    public int getValueSum() {
        return sum;
    }

    @Override
    public int getAgeMean() {
        int size = persons.size();
        int sum = 0;
        if (size != 0) {
            for (int key : persons.keySet()) {
                sum += persons.get(key).getAge();
            }
            return sum / size;
        } else {
            return 0;
        }
    }

    @Override
    public int getAgeVar() {
        int size = persons.size();
        int sum = 0;
        int tem;
        if (size != 0) {
            int mean = getAgeMean();
            for (int key : persons.keySet()) {
                tem = persons.get(key).getAge() - mean;
                sum += tem * tem;
            }
            return sum / size;
        } else {
            return 0;
        }
    }

    @Override
    public void delPerson(Person person) {
        if (hasPerson(person)) {
            for (int key : persons.keySet()) {
                if (person.isLinked(persons.get(key))) {
                    sum -= 2 * person.queryValue(persons.get(key));
                }
            }
            persons.remove(person.getId());
        }
    }

    @Override
    public int getSize() {
        return persons.size();
    }

    public HashMap<Integer, Person> getPersons() {
        return persons;
    }

    public int getSum() {
        return sum;
    }

    public void addSum(int in) {
        sum += in;
    }
}
