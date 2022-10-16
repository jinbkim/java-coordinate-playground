package calculator.model;

import calculator.view.OutputView;
import java.util.List;

public class Line extends AbstractFigure {

    public Line(List<Integer> positions) {
        super(positions);
        if (!isLine()) {
            throw new IllegalArgumentException(OutputView.WRONG_COORDINATE_FORM);
        }
    }

    private boolean isLine() {
        if (points.stream()
            .distinct()
            .count() == points.size()) {
            return true;
        }
        return false;
    }
}
