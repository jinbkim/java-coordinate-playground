package calculator.model;

import calculator.view.OutputView;

public class Position {

    private final static int POSITION_MAX = 24;
    private final int p;

    public Position(int p) {
        if (p > POSITION_MAX) {
            throw new IllegalArgumentException(OutputView.WRONG_COORDINATE_FORM);
        }
        this.p = p;
    }

    public boolean isSame(int p) {
        return this.p == p;
    }

    public boolean isSame(Position position) {
        return p == position.p;
    }

    public double getDiff(Position position) {
        return Math.abs(p - position.p);
    }

    public int get() {
        return p;
    }
}
