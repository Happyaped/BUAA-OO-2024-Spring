import com.oocourse.spec3.main.Person;
import com.oocourse.spec3.main.Tag;

import java.util.HashMap;

public class Maintain {
    public Maintain() {

    }

    public void maintainAddRelationSum(int id1, int id2, int value,
                                       HashMap<Integer, Person> persons) {
        for (int key1 : persons.keySet()) {
            MyPerson temPerson = (MyPerson) persons.get(key1);
            HashMap<Integer, Tag> temTags = temPerson.getTags();
            for (int key2 : temTags.keySet()) {
                MyTag tem1 = (MyTag) temTags.get(key2);
                HashMap<Integer, Person> tem2 = tem1.getPersons();
                if (tem2.containsKey(id1) && tem2.containsKey(id2)) {
                    tem1.addSum(2 * value);
                }
            }
        }
    }

    public void maintainDelRelationSum(int id1, int id2, int value,
                                       HashMap<Integer, Person> persons) {
        for (int key1 : persons.keySet()) {
            MyPerson temPerson = (MyPerson) persons.get(key1);
            HashMap<Integer, Tag> temTags = temPerson.getTags();
            for (int key2 : temTags.keySet()) {
                MyTag tem1 = (MyTag) temTags.get(key2);
                HashMap<Integer, Person> tem2 = tem1.getPersons();
                if (tem2.containsKey(id1) && tem2.containsKey(id2)) {
                    tem1.addSum(-2 * value);
                }
            }
        }
    }

    public void maintainModifyRelationSum(int id1, int id2, int distance,
                                          HashMap<Integer, Person> persons) {
        for (int key1 : persons.keySet()) {
            MyPerson temPerson = (MyPerson) persons.get(key1);
            HashMap<Integer, Tag> temTags = temPerson.getTags();
            for (int key2 : temTags.keySet()) {
                MyTag tem1 = (MyTag) temTags.get(key2);
                HashMap<Integer, Person> tem2 = tem1.getPersons();
                if (tem2.containsKey(id1) && tem2.containsKey(id2)) {
                    tem1.addSum(2 * distance);
                }
            }
        }
    }
}
