public class Person {
    private int id;
    /*private int fromBuilding;
    private int toBuilding;*/
    private int idElevator;
    private int fromFloor;
    private int toFloor;

    public Person(int id, int idElevator, int fromFloor, int toFloor) {
        this.id = id;
        this.idElevator = idElevator;
        /*this.fromBuilding = fromBuilding;
        this.toBuilding = toBuilding;*///迭代时可修改
        this.fromFloor = fromFloor;
        this.toFloor = toFloor;
    }

    public int getId() {
        return id;
    }

    public int getIdElevator() {
        return idElevator;
    }

    public int getFromFloor() {
        return fromFloor;
    }

    public int getToFloor() {
        return toFloor;
    }
}
