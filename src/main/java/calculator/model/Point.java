package calculator.model;


public class Point {

    private final Position x;
    private final Position y;

    public Point(int x, int y) {
        this.x = new Position(x);
        this.y = new Position(y);
    }

    public boolean isPoint(int x, int y) {
        return this.x.isSame(x) && this.y.isSame(y);
    }
}
