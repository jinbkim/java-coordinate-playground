package calculator.model;


public class Point {

    private static final int OUT_OF_RANGE_POS = 25;

    private final Position x;
    private final Position y;

    public Point(int x, int y) {
        this.x = new Position(x);
        this.y = new Position(y);
    }

    public boolean isPoint(int x, int y) {
        return this.x.isSame(x) && this.y.isSame(y);
    }

    public boolean isSame(Point point) {
        return x.isSame(point.x) && y.isSame(point.y);
    }

    public double getInclination(Point point) {
        if (x.getDiff(point.x) == 0) {
            return Double.POSITIVE_INFINITY;
        }
        return y.getDiff(point.y) / x.getDiff(point.x);
    }

    @Override
    public boolean equals(Object o) {
        return isSame((Point) o);
    }

    @Override
    public int hashCode() {
        return x.p * OUT_OF_RANGE_POS + y.p;
    }
}
