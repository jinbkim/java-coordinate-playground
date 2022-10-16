package calculator.model;

import calculator.view.OutputView;
import java.util.List;

public class Line extends AbstractFigure {

    public Line(List<Integer> positions) {
        super(positions);
        if (points.stream()
            .distinct()
            .count() != points.size()) {
            throw new IllegalArgumentException(OutputView.WRONG_COORDINATE_FORM);
        }
    }
}
