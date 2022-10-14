package calculator.model;

public class Pos {

    private static final int COORDINATE_RANGE_MAX = 24;

    private final int p;

    public Pos(int p) {
        validatePositionRange(p);
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

    private void validatePositionRange(int position) {
        if (position > COORDINATE_RANGE_MAX) {
            throw new IllegalArgumentException();
        }
    }
}
