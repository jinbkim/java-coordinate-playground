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

    public boolean isSameX(Coordinate coordinate) {
        return x.isSame(coordinate.x);
    }

    public boolean isSameY(int y) {
        return this.y.isSame(y);
    }

    public boolean isSameY(Coordinate coordinate) {
        return y.isSame(coordinate.y);
    }

    public double getLineDistance(Coordinate c) {
        return Math.sqrt(Math.pow(x.getDiff(c.x), 2) + Math.pow(y.getDiff(c.y), 2));
    }

    public double getInclination(Coordinate c) {
        if (x.getDiff(c.x) == 0) {
            return Double.POSITIVE_INFINITY;
        }
        return Math.abs(y.getDiff(c.y) / x.getDiff(c.x));
    }
}
