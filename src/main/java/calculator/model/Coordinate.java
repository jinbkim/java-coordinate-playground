package calculator.model;

public class Coordinate {

    private final Pos x;
    private final Pos y;

    public Coordinate(int x, int y) {
        this.x = new Pos(x);
        this.y = new Pos(y);
    }

    public boolean isSameX(int x) {
        return this.x.isSame(x);
    }

    public boolean isSameY(int y) {
        return this.y.isSame(y);
    }

    public double getDistance(Coordinate c) {
        return Math.sqrt(Math.pow(x.get() - c.x.get(), 2) + Math.pow(y.get() - c.y.get(), 2));
    }
}
