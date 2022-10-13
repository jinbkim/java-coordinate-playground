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
}
