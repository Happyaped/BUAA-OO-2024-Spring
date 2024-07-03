import com.oocourse.spec2.main.Person;

import java.util.HashMap;

public class DisjointSet {
    private HashMap<Integer, Integer> fatherMap;//父子关系
    private HashMap<Integer, Integer> rankMap;//用于优化

    public DisjointSet() {
        this.fatherMap = new HashMap<>();
        this.rankMap = new HashMap<>();

    }

    public void add(int id) {
        if (!fatherMap.containsKey(id)) {
            fatherMap.put(id, id);
            rankMap.put(id, 0);
        }
    }

    public int find(int id) {
        int rep = id;
        while (rep != fatherMap.get(rep)) {
            rep = fatherMap.get(rep);
        }
        int now = id;
        while (now != rep) {
            int fa = fatherMap.get(now);
            fatherMap.put(now, rep);
            now = fa;
        }
        return rep;
    }

    public void merge(int id1, int id2) {
        int fa1 = find(id1);
        int fa2 = find(id2);
        if (fa1 == fa2) {
            return;
        }
        int rank1 = rankMap.get(fa1);
        int rank2 = rankMap.get(fa2);
        if (rank1 < rank2) {
            fatherMap.put(fa1, fa2);
        } else {
            if (rank1 == rank2) {
                rankMap.put(fa1, rank1 + 1);
            }
            fatherMap.put(fa2, fa1);
        }
    }

    public void delete(HashMap<Integer, Person> persons) {
        //负责删除并且彻底重建并查集
        //先彻底删除
        fatherMap.clear();
        rankMap.clear();
        //再把所有的人加入
        for (int key : persons.keySet()) {
            add(key);
        }
        //再添加关系
        for (int key : persons.keySet()) {
            MyPerson people = (MyPerson) persons.get(key);
            HashMap<Integer, Person> peopleMap = people.getAcquaintance();
            //拿到了关系
            for (int key1 : peopleMap.keySet()) {
                if (key1 >= key) {
                    merge(key, key1);
                }
                //合并重建并查集
            }
        }
    }
}
