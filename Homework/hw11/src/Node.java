public class Node implements Comparable<Node> {
    private final int to;
    private final int value;

    public Node(int to, int value) {
        this.to = to;
        this.value = value;
    }

    @Override
    public int compareTo(Node o) {
        return this.value - o.value;
    }

    public int getTo() {
        return to;
    }

    public int getValue() {
        return value;
    }
}
