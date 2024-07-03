import java.util.HashMap;

public class Counter {
    private HashMap<Integer, Integer> map;//id是key，对应的次数是value
    private int sum;//该异常被调用的总次数

    public Counter() {
        map = new HashMap<>();
        sum = 0;

    }

    public void addCount(int id) {
        sum++;
        if (map.containsKey(id)) {
            //如果包含了id
            int tem = map.get(id) + 1;
            map.remove(id);
            map.put(id, tem);
        } else {
            //如果不包含id
            map.put(id, 1);
        }
    }

    public void addDoubleCount(int id1, int id2) {
        sum++;
        if (map.containsKey(id1)) {
            //如果包含了id1
            int tem = map.get(id1) + 1;
            map.remove(id1);
            map.put(id1, tem);
        } else {
            //如果不包含id1
            map.put(id1, 1);
        }
        if (map.containsKey(id2)) {
            //如果包含了id2
            int tem = map.get(id2) + 1;
            map.remove(id2);
            map.put(id2, tem);
        } else {
            //如果不包含id2
            map.put(id2, 1);
        }
    }

    public int getSum() {
        return sum;
    }

    public int getIdCount(int id) {
        return map.get(id);
    }
}
