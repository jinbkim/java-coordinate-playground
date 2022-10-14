package calculator.model;

import calculator.utils.Validator;

public class Pos {

    private final Validator validator = new Validator();

    private final int p;

    public Pos(int p) {
        validator.validateCoordinateRange(p);
        this.p = p;
    }

    public int getDiff(Pos pos) {
        return this.p - pos.p;
    }

    public boolean isSame(int p) {
        return this.p == p;
    }

    public boolean isSame(Pos pos) {
        return this.p == pos.p;
    }
}
