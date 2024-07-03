public class Person {
    private int id;
    /*private int fromBuilding;
    private int toBuilding;*/
    private int fromFloor;
    private int toFloor;

    public Person(int id, int fromFloor, int toFloor) {
        this.id = id;
        /*this.fromBuilding = fromBuilding;
        this.toBuilding = toBuilding;*///迭代时可修改
        this.fromFloor = fromFloor;
        this.toFloor = toFloor;
    }

    public int getId() {
        return id;
    }

    public int getFromFloor() {
        return fromFloor;
    }

    public int getToFloor() {
        return toFloor;
    }

    public void setFromFloor(int fromFloor) {
        this.fromFloor = fromFloor;
    }
}
