package calculator.model;

public class Position {

    int p;

    public Position(int p) {
        this.p = p;
    }

    public boolean isSame(int p) {
        return this.p == p;
    }

    public boolean isSame(Position position) {
        return p == position.p;
    }

    public int getDiff(Position position) {
        return Math.abs(p - position.p);
    }

}
