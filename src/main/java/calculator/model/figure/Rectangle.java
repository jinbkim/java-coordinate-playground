package calculator.model.figure;

import calculator.model.Point;
import calculator.view.OutputView;
import java.util.List;

public class Rectangle extends AbstractFigure {

    private static final int NUM_OF_POINT_SAME_X_AND_DIFFERENT_Y = 1;
    private static final int NUM_OF_POINT_SAME_Y_AND_DIFFERENT_X = 1;

    public Rectangle(List<Integer> positions) {
        super(positions);
        if (!isRectangle()) {
            throw new IllegalArgumentException(OutputView.WRONG_COORDINATE_FORM);
        }
    }

    @Override
    public void printResult() {
        System.out.println(OutputView.RECTANGLE_AREA + getArea());
    }

    public double getArea() {
        Point coordinate = getPoints().get(0);

        Double width = getWidth(coordinate);
        Double height = getHeight(coordinate);
        return width * height;
    }

    private double getWidth(Point basePoint) {
        return getPoints().stream()
            .filter(point -> point.sameYAndDifferentX(basePoint))
            .map(point -> point.getDistance(basePoint))
            .findAny()
            .get();
    }

    private double getHeight(Point basePoint) {
        return getPoints().stream()
            .filter(point -> point.sameXAndDifferentY(basePoint))
            .map(point -> point.getDistance(basePoint))
            .findAny()
            .get();
    }

    private boolean isRectangle() {
        for (Point point : getPoints()) {
            if (getPoints().stream()
                .filter(p -> p.sameXAndDifferentY(point))
                .count() != NUM_OF_POINT_SAME_X_AND_DIFFERENT_Y) {
                return false;
            }
            if (getPoints().stream()
                .filter(p -> p.sameYAndDifferentX(point))
                .count() != NUM_OF_POINT_SAME_Y_AND_DIFFERENT_X) {
                return false;
            }
        }
        return true;
    }
}
