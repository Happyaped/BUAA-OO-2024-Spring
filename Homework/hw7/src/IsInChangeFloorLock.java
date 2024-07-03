public class IsInChangeFloorLock {
    private Integer isInChangeFloor;//标志换乘楼层是否被占，0代表没有，1代表被占了

    public IsInChangeFloorLock() {
        isInChangeFloor = 0;
    }

    public synchronized void setIsInChangeFloor(Integer isInChangeFloor) {
        this.isInChangeFloor = isInChangeFloor;
    }

    public synchronized Integer getIsInChangeFloor() {
        return isInChangeFloor;
    }
}
