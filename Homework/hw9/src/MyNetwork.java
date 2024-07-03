
import com.oocourse.spec1.exceptions.EqualPersonIdException;
import com.oocourse.spec1.exceptions.EqualRelationException;
import com.oocourse.spec1.exceptions.PersonIdNotFoundException;
import com.oocourse.spec1.exceptions.RelationNotFoundException;
import com.oocourse.spec1.main.Network;
import com.oocourse.spec1.main.Person;

import java.util.HashMap;

public class MyNetwork implements Network {
    private HashMap<Integer, Person> persons;//id是key，person是value，代表了所有人
    private DisjointSet disjointSet;//并查集
    private int blockSum;//代表block数量
    private int triSum;//代表tri数量

    public MyNetwork() {
        persons = new HashMap<>();
        disjointSet = new DisjointSet();
        blockSum = 0;
        triSum = 0;
    }

    public Person[] getPersons() {
        return null;
    }

    @Override
    public boolean containsPerson(int id) {
        return persons.containsKey(id);
    }

    @Override
    public Person getPerson(int id) {
        if (persons.containsKey(id)) {
            return persons.get(id);
        } else {
            return null;
        }
    }

    @Override
    public void addPerson(Person person) throws EqualPersonIdException {
        if (!persons.containsKey(person.getId())) {
            persons.put(person.getId(), person);
            disjointSet.add(person.getId());
            blockSum++;
        } else {
            throw new MyEqualPersonIdException(person.getId());
        }
    }

    @Override
    public void addRelation(int id1, int id2, int value) throws
            PersonIdNotFoundException, EqualRelationException {
        int mark = 0;
        Person temPerson1;
        Person temPerson2;
        if (persons.containsKey(id1) && persons.containsKey(id2)) {
            mark = 1;
            temPerson1 = persons.get(id1);
            temPerson2 = persons.get(id2);
            if (!temPerson1.isLinked(temPerson2)) {
                mark = 2;
                if (temPerson1 instanceof MyPerson && temPerson2 instanceof MyPerson) {
                    for (int key : persons.keySet()) {
                        //拿到每个人的id是key
                        if (key == id1 || key == id2) {
                            continue;
                        }
                        if (temPerson1.isLinked(persons.get(key)) &&
                                temPerson2.isLinked(persons.get(key))) {
                            triSum++;
                        }
                    }
                    ((MyPerson) temPerson1).addAcquaintance(temPerson2);
                    ((MyPerson) temPerson1).addValue(temPerson2, value);
                    ((MyPerson) temPerson2).addAcquaintance(temPerson1);
                    ((MyPerson) temPerson2).addValue(temPerson1, value);
                    if (disjointSet.find(id1) != disjointSet.find(id2)) {
                        blockSum--;
                    }
                    disjointSet.merge(id1, id2);
                }
            }
        }
        if (mark == 1) {
            throw new MyEqualRelationException(id1, id2);
        } else if (mark == 0) {
            if (!persons.containsKey(id1)) {
                throw new MyPersonIdNotFoundException(id1);
            } else {
                throw new MyPersonIdNotFoundException(id2);
            }
        }

    }

    @Override
    public void modifyRelation(int id1, int id2, int value) throws
            PersonIdNotFoundException, EqualPersonIdException,
            MyRelationNotFoundException {
        int mark = 0;
        Person temPerson1;
        Person temPerson2;
        if (persons.containsKey(id1) && persons.containsKey(id2)) {
            mark = 1;
            if (id1 != id2) {
                mark = 2;
                temPerson1 = persons.get(id1);
                temPerson2 = persons.get(id2);
                if (temPerson1.isLinked(temPerson2)) {
                    mark = 3;
                    if (temPerson1.queryValue(temPerson2) + value > 0) {
                        if (temPerson1 instanceof MyPerson && temPerson2 instanceof MyPerson) {
                            ((MyPerson) temPerson1).changeValue(temPerson2, value);
                            ((MyPerson) temPerson2).changeValue(temPerson1, value);

                        }
                    } else {
                        if (temPerson1 instanceof MyPerson && temPerson2 instanceof MyPerson) {
                            for (int key : persons.keySet()) {
                                //遍历persons
                                if (key == id1 || key == id2) {
                                    continue;
                                }
                                if (temPerson1.isLinked(persons.get(key)) &&
                                        temPerson2.isLinked(persons.get(key))) {
                                    triSum--;
                                }
                            }
                            ((MyPerson) temPerson1).deleteAcquaintance(temPerson2);
                            ((MyPerson) temPerson1).deleteValue(temPerson2);
                            ((MyPerson) temPerson2).deleteAcquaintance(temPerson1);
                            ((MyPerson) temPerson2).deleteValue(temPerson1);
                            disjointSet.delete(persons);
                            if (disjointSet.find(id1) != disjointSet.find(id2)) {
                                blockSum++;
                            }
                        }
                    }
                }
            }
        }
        if (mark == 0) {
            if (!persons.containsKey(id1)) {
                throw new MyPersonIdNotFoundException(id1);
            } else {
                throw new MyPersonIdNotFoundException(id2);
            }
        } else if (mark == 1) {
            throw new MyEqualPersonIdException(id1);
        } else if (mark == 2) {
            throw new MyRelationNotFoundException(id1, id2);
        }
    }

    @Override
    public int queryValue(int id1, int id2) throws
            PersonIdNotFoundException, RelationNotFoundException {
        int mark = 0;
        Person temPerson1;
        Person temPerson2;
        if (persons.containsKey(id1) && persons.containsKey(id2)) {
            mark = 1;
            temPerson1 = persons.get(id1);
            temPerson2 = persons.get(id2);
            if (temPerson1.isLinked(temPerson2)) {
                mark = 2;
                return temPerson1.queryValue(temPerson2);
            }
        }
        if (mark == 0) {
            if (!persons.containsKey(id1)) {
                throw new MyPersonIdNotFoundException(id1);
            } else {
                throw new MyPersonIdNotFoundException(id2);
            }
        } else if (mark == 1) {
            throw new MyRelationNotFoundException(id1, id2);
        }
        return 0;
    }

    @Override
    public boolean isCircle(int id1, int id2) throws PersonIdNotFoundException {
        if (persons.containsKey(id1) && persons.containsKey(id2)) {
            return disjointSet.find(id1) == disjointSet.find(id2);
        } else {
            if (!persons.containsKey(id1)) {
                throw new MyPersonIdNotFoundException(id1);
            } else {
                throw new MyPersonIdNotFoundException(id2);
            }
        }
    }

    @Override
    public int queryBlockSum() {
        return blockSum;
    }

    @Override
    public int queryTripleSum() {
        return triSum;
    }
}
