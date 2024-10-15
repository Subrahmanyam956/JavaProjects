public class Jumper {
    private int startPos;
    private int endPos;

    public Jumper(int sPos, int ePos) {
        this.startPos = sPos;
        this.endPos = ePos;
    }

    public int getStartPos() {
        return startPos;
    }

    public void setStartPos(int startPos) {
        this.startPos = startPos;
    }

    public int getEndPos() {
        return endPos;
    }

    public void setEndPos(int endPos) {
        this.endPos = endPos;
    }
}
