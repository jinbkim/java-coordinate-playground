package calculator.model;

import calculator.view.OutputView;
import java.util.List;

public class RectangleCalculator extends Calculator {

    private static final int CROSSING_HORIZONTAL_POINT_COUNT = 1;
    private static final int CROSSING_VERTICAL_POINT_COUNT = 1;

    public RectangleCalculator(List<Integer> coordinates) {
        super(coordinates);
        if (!isRectangle()) {
            throw new IllegalArgumentException(OutputView.WRONG_COORDINATE);
        }
    }

    public void printResult() {

    }

    private boolean isRectangle() {
        for (Coordinate coordinate : coordinates) {
            if (coordinates.stream()
                .filter(c -> c.isSameX(coordinate) && !c.isSameY(coordinate))
                .count() != CROSSING_HORIZONTAL_POINT_COUNT) {
                return false;
            }
            if (coordinates.stream()
                .filter(c -> !c.isSameX(coordinate) && c.isSameY(coordinate))
                .count() != CROSSING_VERTICAL_POINT_COUNT) {
                return false;
            }
        }
        return true;
    }
}
