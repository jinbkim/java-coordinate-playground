package calculator.model;

public class Coordinate {

    private final Pos x;
    private final Pos y;

    public Coordinate(int x, int y) {
        this.x = new Pos(x);
        this.y = new Pos(y);
    }

    public Pos getX() {
        return x;
    }

    public Pos getY() {
        return y;
    }

    public boolean isSameX(int x) {
        return this.x.isSame(x);
    }

    public boolean isSameY(int y) {
        return this.y.isSame(y);
    }
}
