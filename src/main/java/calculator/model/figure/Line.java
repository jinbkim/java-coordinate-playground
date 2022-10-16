package calculator.model.figure;

import calculator.model.Point;
import calculator.view.OutputView;
import java.util.List;

public class Line extends AbstractFigure {

    public Line(List<Integer> positions) {
        super(positions);
        if (!isLine()) {
            throw new IllegalArgumentException(OutputView.WRONG_COORDINATE_FORM);
        }
    }

    @Override
    public void printResult() {
        Point pointA = getPoints().get(0);
        Point pointB = getPoints().get(1);

        System.out.println(OutputView.LINE_DISTANCE + pointA.getDistance(pointB));
    }

    private boolean isLine() {
        if (getPoints().stream()
            .distinct()
            .count() == getPoints().size()) {
            return true;
        }
        return false;
    }
}
