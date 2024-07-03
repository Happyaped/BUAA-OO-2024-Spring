import java.util.ArrayList;
import java.util.HashMap;

public class RequestTable {
    private boolean isEnd;
    private HashMap<Integer, ArrayList<Person>> requestMap;//！！！可能需要notifyall

    public RequestTable() {
        requestMap = new HashMap<>();
        for (int i = 1; i < 12; i++) {
            requestMap.put(i, new ArrayList<>());
        }
        isEnd = false;
    }

    public synchronized HashMap<Integer, ArrayList<Person>> getRequestMap() {
        return requestMap;
    }

    public synchronized void setEnd(Boolean isEnd) {
        this.isEnd = isEnd;
        notifyAll();
    }

    public synchronized void addRequestMap(Person person) {
        ArrayList<Person> tem = requestMap.get(person.getFromFloor());
        tem.add(person);
        notifyAll();
    }

    public synchronized boolean isEnd() {
        return isEnd;
    }

    public synchronized boolean isEmpty() {
        int mark = 0;
        for (int key : requestMap.keySet()) {
            if (requestMap.get(key).size() != 0) {
                mark = 1;
                break;
            }
        }
        if (mark == 1) {
            return false;
        } else {
            return true;
        }
    }

    public synchronized Person getOnePersonAndRemove() {
        if (requestMap.isEmpty()) {
            return null;
        }
        Person person = null;
        ArrayList<Person> tem = null;
        for (int key : requestMap.keySet()) {
            if (requestMap.get(key).size() != 0) {
                tem = requestMap.get(key);
                break;
            }
        }
        if (tem != null) {
            person = tem.get(0);
            tem.remove(0);
        }
        notifyAll();
        return person;
    }
}
