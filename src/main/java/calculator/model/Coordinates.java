package calculator.model;

import java.util.List;

public class Coordinates {

    private final Coordinate src;
    private final Coordinate dst;

    public Coordinates(List<Integer> coordinates) {
        src = new Coordinate(coordinates.get(0), coordinates.get(1));
        dst = new Coordinate(coordinates.get(2), coordinates.get(3));
    }

    public Coordinate getSrc() {
        return src;
    }

    public Coordinate getDst() {
        return dst;
    }
}
