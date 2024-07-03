import com.oocourse.spec3.main.Person;

import java.util.HashMap;
import java.util.PriorityQueue;

public class Dijkstra {
    public Dijkstra() {

    }

    public HashMap<Integer, Integer> dijkstra(int id, HashMap<Integer, Person> persons,
                                              HashMap<Integer, HashMap<Integer, Integer>>
                                                      maintainIdMap) {
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
}
