
import com.oocourse.spec2.exceptions.AcquaintanceNotFoundException;
import com.oocourse.spec2.exceptions.EqualPersonIdException;
import com.oocourse.spec2.exceptions.EqualRelationException;
import com.oocourse.spec2.exceptions.EqualTagIdException;
import com.oocourse.spec2.exceptions.PathNotFoundException;
import com.oocourse.spec2.exceptions.PersonIdNotFoundException;
import com.oocourse.spec2.exceptions.RelationNotFoundException;
import com.oocourse.spec2.exceptions.TagIdNotFoundException;
import com.oocourse.spec2.main.Network;
import com.oocourse.spec2.main.Person;
import com.oocourse.spec2.main.Tag;

import java.util.HashMap;
import java.util.PriorityQueue;

public class MyNetwork implements Network {
    private HashMap<Integer, Person> persons;//id是key，person是value，代表了所有人
    private HashMap<Integer, Integer> bestFriends;//最好朋友
    private HashMap<Integer, HashMap<Integer, Integer>> maintainIdMap;
    //维护dijkstra,id是key，value就是以这个id为根节点的图
    private Boolean isDirty;//维护dijkstra是否脏了
    private DisjointSet disjointSet;//并查集
    private int blockSum;//代表block数量
    private int triSum;//代表tri数量

    public MyNetwork() {
        persons = new HashMap<>();
        bestFriends = new HashMap<>();
        maintainIdMap = new HashMap<>();
        isDirty = false;
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
            bestFriends.put(person.getId(), person.getId());
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
                    maintainAddRelationSum(id1, id2, value);
                    ((MyPerson) temPerson1).addAcquaintance(temPerson2);
                    ((MyPerson) temPerson1).addValue(temPerson2, value);
                    ((MyPerson) temPerson2).addAcquaintance(temPerson1);
                    ((MyPerson) temPerson2).addValue(temPerson1, value);
                    int preId1 = bestFriends.get(id1);
                    int preId2 = bestFriends.get(id2);
                    bestFriends.put(id1, ((MyPerson) temPerson1).getBestFriendId(preId1, id2));
                    bestFriends.put(id2, ((MyPerson) temPerson2).getBestFriendId(preId2, id1));
                    if (disjointSet.find(id1) != disjointSet.find(id2)) {
                        blockSum--;
                    }
                    disjointSet.merge(id1, id2);
                    isDirty = true;
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
                            maintainModifyRelationSum(id1, id2, value);
                            ((MyPerson) temPerson1).changeValue(temPerson2, value);
                            ((MyPerson) temPerson2).changeValue(temPerson1, value);
                            int preId1 = bestFriends.get(id1);
                            int preId2 = bestFriends.get(id2);
                            bestFriends.put(id1, ((MyPerson) temPerson1).
                                    changeGetBestFriendId(preId1, id2));
                            bestFriends.put(id2, ((MyPerson) temPerson2).
                                    changeGetBestFriendId(preId2, id1));  }  } else {
                        if (temPerson1 instanceof MyPerson && temPerson2 instanceof MyPerson) {
                            for (int key : persons.keySet()) {
                                if (key == id1 || key == id2) {
                                    continue;                                }
                                if (temPerson1.isLinked(persons.get(key)) &&
                                        temPerson2.isLinked(persons.get(key))) {
                                    triSum--;    }            }
                            maintainDelRelationSum(id1, id2, temPerson1.queryValue(temPerson2));
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
                                blockSum++;         }
                            isDirty = true;  } } } } }
        if (mark == 0) {
            if (!persons.containsKey(id1)) {
                throw new MyPersonIdNotFoundException(id1);  } else {
                throw new MyPersonIdNotFoundException(id2);   }
        } else if (mark == 1) {
            throw new MyEqualPersonIdException(id1);     } else if (mark == 2) {
            throw new MyRelationNotFoundException(id1, id2);   }
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
                return temPerson1.queryValue(temPerson2);   }   }
        if (mark == 0) {
            if (!persons.containsKey(id1)) {
                throw new MyPersonIdNotFoundException(id1);  } else {
                throw new MyPersonIdNotFoundException(id2);     }
        } else if (mark == 1) {
            throw new MyRelationNotFoundException(id1, id2);   }
        return 0;
    }

    @Override
    public boolean isCircle(int id1, int id2) throws PersonIdNotFoundException {
        if (persons.containsKey(id1) && persons.containsKey(id2)) {
            return disjointSet.find(id1) == disjointSet.find(id2);  } else {
            if (!persons.containsKey(id1)) {
                throw new MyPersonIdNotFoundException(id1); } else {
                throw new MyPersonIdNotFoundException(id2);  } }
    }

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
        int mark = 0;
        if (containsPerson(personId)) {
            mark = 1;
            if (!getPerson(personId).containsTag(tag.getId())) {
                mark = 2;
                getPerson(personId).addTag(tag);  }  }
        if (mark == 0) {
            throw new MyPersonIdNotFoundException(personId);
        } else if (mark == 1) {
            throw new MyEqualTagIdException(tag.getId());  }  }

    @Override
    public void addPersonToTag(int personId1, int personId2, int tagId) throws
            PersonIdNotFoundException, RelationNotFoundException,
            TagIdNotFoundException, EqualPersonIdException {
        int mark = 0;
        MyTag tag;
        if (containsPerson(personId1) && containsPerson(personId2) && personId1 != personId2) {
            mark = 2;
            if (getPerson(personId2).isLinked(getPerson(personId1))) {
                mark = 3;
                if (getPerson(personId2).containsTag(tagId)) {
                    mark = 4;
                    if (!getPerson(personId2).getTag(tagId).hasPerson(getPerson(personId1))) {
                        mark = 5;
                        tag = (MyTag) getPerson(personId2).getTag(tagId);
                        HashMap<Integer, Person> tem = tag.getPersons();
                        if (tem.size() <= 1111) {
                            tag.addPerson(getPerson(personId1)); } } } } }
        if (mark == 0) {
            if (!persons.containsKey(personId1)) {
                throw new MyPersonIdNotFoundException(personId1);
            } else if (!persons.containsKey(personId2)) {
                throw new MyPersonIdNotFoundException(personId2);
            } else {
                throw new MyEqualPersonIdException(personId1);
            }
        } else if (mark == 2) {
            throw new MyRelationNotFoundException(personId1, personId2);
        } else if (mark == 3) {
            throw new MyTagIdNotFoundException(tagId);
        } else if (mark == 4) {
            throw new MyEqualPersonIdException(personId1);
        }
    }

    @Override
    public int queryTagValueSum(int personId, int tagId) throws
            PersonIdNotFoundException, TagIdNotFoundException {
        int mark = 0;
        if (containsPerson(personId)) {
            mark = 1;
            if (getPerson(personId).containsTag(tagId)) {
                mark = 2;
                return getPerson(personId).getTag(tagId).getValueSum();  } }
        if (mark == 0) {
            throw new MyPersonIdNotFoundException(personId);
        } else if (mark == 1) {
            throw new MyTagIdNotFoundException(tagId);   }
        return 0;  }

    @Override
    public int queryTagAgeVar(int personId, int tagId) throws
            PersonIdNotFoundException, TagIdNotFoundException {
        int mark = 0;
        if (containsPerson(personId)) {
            mark = 1;
            if (getPerson(personId).containsTag(tagId)) {
                mark = 2;
                return getPerson(personId).getTag(tagId).getAgeVar();  }     }
        if (mark == 0) {
            throw new MyPersonIdNotFoundException(personId);
        } else if (mark == 1) {
            throw new MyTagIdNotFoundException(tagId);
        }
        return 0;
    }

    @Override
    public void delPersonFromTag(int personId1, int personId2, int tagId)
            throws PersonIdNotFoundException, TagIdNotFoundException {
        int mark = 0;
        Tag tag;
        if (containsPerson(personId1) && containsPerson(personId2)) {
            mark = 1;
            if (getPerson(personId2).containsTag(tagId)) {
                mark = 2;
                if (getPerson(personId2).getTag(tagId).hasPerson(getPerson(personId1))) {
                    mark = 3;
                    tag = getPerson(personId2).getTag(tagId);
                    tag.delPerson(getPerson(personId1));
                }
            }
        }
        if (mark == 0) {
            if (!persons.containsKey(personId1)) {
                throw new MyPersonIdNotFoundException(personId1);
            } else {
                throw new MyPersonIdNotFoundException(personId2);
            }
        } else if (mark == 1) {
            throw new MyTagIdNotFoundException(tagId);
        } else if (mark == 2) {
            throw new MyPersonIdNotFoundException(personId1);
        }
    }

    @Override
    public void delTag(int personId, int tagId) throws
            PersonIdNotFoundException, TagIdNotFoundException {
        int mark = 0;
        if (containsPerson(personId)) {
            mark = 1;
            if (getPerson(personId).containsTag(tagId)) {
                mark = 2;
                getPerson(personId).delTag(tagId);
            }
        }
        if (mark == 0) {
            throw new MyPersonIdNotFoundException(personId);
        } else if (mark == 1) {
            throw new MyTagIdNotFoundException(tagId);
        }
    }

    @Override
    public int queryBestAcquaintance(int id) throws
            PersonIdNotFoundException, AcquaintanceNotFoundException {
        int mark = 0;
        MyPerson temPerson;
        if (containsPerson(id)) {
            mark = 1;
            temPerson = (MyPerson) getPerson(id);
            if (temPerson.getAcquaintance().size() != 0) {
                mark = 2;
                return bestFriends.get(id);
            }
        }
        if (mark == 0) {
            throw new MyPersonIdNotFoundException(id);
        } else if (mark == 1) {
            throw new MyAcquaintanceNotFoundException(id);
        }
        return 0;
    }

    @Override
    public int queryCoupleSum() {
        int sum = 0;
        for (int key : bestFriends.keySet()) {
            int tem1 = bestFriends.get(key);
            int tem2 = bestFriends.get(tem1);
            if (tem1 != key && tem2 == key) {
                sum++;
            }
        }
        return sum / 2;
    }

    @Override
    public int queryShortestPath(int id1, int id2) throws
            PersonIdNotFoundException, PathNotFoundException {
        int mark = 0;
        if (containsPerson(id1) && containsPerson(id2)) {
            mark = 1;
            if (isCircle(id1, id2)) {
                mark = 2;
                if (id1 == id2) {
                    return 0;
                }
                if (isDirty == true) {
                    //维护的当前无效
                    maintainIdMap.clear();
                    HashMap<Integer, Integer> tem = dijkstra(id1);
                    isDirty = false;
                    return tem.get(id2) - 1;
                } else {
                    //维护的当前有效
                    if (maintainIdMap.containsKey(id1)) {
                        HashMap<Integer, Integer> tem = maintainIdMap.get(id1);
                        return tem.get(id2) - 1;
                    } else if (maintainIdMap.containsKey(id2)) {
                        HashMap<Integer, Integer> tem = maintainIdMap.get(id2);
                        return tem.get(id1) - 1;
                    } else {
                        HashMap<Integer, Integer> tem = dijkstra(id1);
                        return tem.get(id2) - 1;
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
            throw new MyPathNotFoundException(id1, id2);
        }
        return 0;
    }

    public HashMap<Integer, Integer> dijkstra(int id) {
        HashMap<Integer, Integer> dis = new HashMap<>();
        // 记录某个节点是否被访问过
        HashMap<Integer, Boolean> vis = new HashMap<>();
        // 创建优先队列
        PriorityQueue<Node> heap = new PriorityQueue<>();

        // dis和vis的初始化
        for (Integer i : persons.keySet()) {
            dis.put(i, Integer.MAX_VALUE);
            vis.put(i, false);
        }
        dis.put(id, 0);
        heap.add(new Node(id, 0));
        while (!heap.isEmpty()) {
            Node cur = heap.poll();
            int curId = cur.getTo();
            if (vis.get(curId)) {
                continue;
            }
            vis.put(curId, true);
            MyPerson person = (MyPerson) persons.get(curId);
            for (Integer friendId : person.getAcquaintance().keySet()) {
                if (!vis.get(friendId) && dis.get(curId) + 1 < dis.get(friendId)) {
                    dis.put(friendId, dis.get(curId) + 1);
                    heap.add(new Node(friendId, dis.get(friendId)));
                }
            }
        }
        maintainIdMap.put(id, dis);
        return dis;
    }

    public void maintainAddRelationSum(int id1, int id2, int value) {
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

    public void maintainDelRelationSum(int id1, int id2, int value) {
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

    public void maintainModifyRelationSum(int id1, int id2, int distance) {
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
