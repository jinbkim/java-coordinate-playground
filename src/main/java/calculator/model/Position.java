package calculator.model;

public class Position {

    int p;

    public Position(int p) {
        this.p = p;
    }

    public boolean isSame(int p) {
        return this.p == p;
    }
}
