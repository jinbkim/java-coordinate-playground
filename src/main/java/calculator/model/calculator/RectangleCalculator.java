package calculator.model.calculator;

import calculator.model.Coordinate;
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
        System.out.println(OutputView.RECTANGLE_AREA + getArea());
    }

    public double getArea() {
        Coordinate coordinate = coordinates.get(0);

        Double width = getWidth(coordinate);
        Double height = getHeight(coordinate);
        return width * height;
    }

    private double getWidth(Coordinate baseCoordinate) {
        return coordinates.stream()
            .filter(c -> !c.isSameX(baseCoordinate) && c.isSameY(baseCoordinate))
            .map(c -> c.getLineDistance(baseCoordinate))
            .findFirst()
            .get();
    }

    private double getHeight(Coordinate baseCoordinate) {
        return coordinates.stream()
            .filter(c -> c.isSameX(baseCoordinate) && !c.isSameY(baseCoordinate))
            .map(c -> c.getLineDistance(baseCoordinate))
            .findFirst()
            .get();
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
