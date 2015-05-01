package ASRS;

/**
 * Created by Willem on 1-5-2015.
 */
public class Locatie {
    private int x;
    private int y;

    public Locatie(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

}
