public class CarRequest implements Comparable<CarRequest> {
    private int curFloor;
    private int targetFloor;
    private boolean upDirection;

    public CarRequest(int curFloor, int targetFloor, boolean upDirection) {
        this.curFloor = curFloor;
        this.targetFloor = targetFloor;
        this.upDirection = upDirection;
    }

    @Override
    public int compareTo(CarRequest other) {
        // Compare based only on curFloor
        return Integer.compare(this.curFloor, other.curFloor);
    }


    public int getCurFloor() {
        return curFloor;
    }

    public void setCurFloor(int curFloor) {
        this.curFloor = curFloor;
    }

    public int getTargetFloor() {
        return targetFloor;
    }

    public void setTargetFloor(int targetFloor) {
        this.targetFloor = targetFloor;
    }

    public boolean isUpDirection() {
        return upDirection;
    }

    public void setUpDirection(boolean upDirection) {
        this.upDirection = upDirection;
    }
}
