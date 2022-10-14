package calculator.model.calculator;

import calculator.model.Coordinate;
import calculator.view.OutputView;
import java.util.List;

public class TriangleCalculator extends Calculator {

    public TriangleCalculator(List<Integer> coordinates) {
        super(coordinates);
        if (!isTriangle()) {
            throw new IllegalArgumentException(OutputView.WRONG_COORDINATE);

        }
    }

    public void printResult() {

    }

    private boolean isTriangle() {
        Coordinate baseCoordinate = coordinates.get(0);
        Coordinate coordinateA = coordinates.get(1);
        Coordinate coordinateB = coordinates.get(2);

        if (baseCoordinate.getInclination(coordinateA) == baseCoordinate.getInclination(coordinateB)) {
            return false;
        }
        return true;
    }
}
