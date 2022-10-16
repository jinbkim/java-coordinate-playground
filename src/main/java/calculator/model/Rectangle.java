package calculator.model;

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

    private boolean isRectangle() {
        for (Point point : points) {
            if (points.stream()
                .filter(p -> p.sameXAndDifferntY(point))
                .count() != NUM_OF_POINT_SAME_X_AND_DIFFERENT_Y) {
                return false;
            }
            if (points.stream()
                .filter(p -> p.sameYAndDifferentX(point))
                .count() != NUM_OF_POINT_SAME_Y_AND_DIFFERENT_X) {
                return false;
            }
        }
        return true;
    }
}
