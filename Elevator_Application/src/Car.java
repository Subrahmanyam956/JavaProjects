public class Car {
    private int curFloor;
    private int state;
    private boolean isUpDirection;

    public Car(int curFloor, int state, boolean isUpDirection) {
        this.curFloor = curFloor;
        this.state = state;
//        if state == 1 => Moving cart
//        else if state == 0  => Idle cart
        this.isUpDirection = isUpDirection;
    }

    public int getCurFloor() {
        return curFloor;
    }

    public void setCurFloor(int curFloor) {
        this.curFloor = curFloor;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public boolean isUpDirection() {
        return isUpDirection;
    }

    public void setUpDirection(boolean upDirection) {
        isUpDirection = upDirection;
    }
}
