package calculator.model;

import calculator.view.OutputView;
import java.util.List;

public class LineCalculator extends Calculator {

    public LineCalculator(List<Integer> coordinates) {
        super(coordinates);
    }

    public void printResult() {
        System.out.println(OutputView.LINE_DISTANCE + coordinates.get(0)
            .getLineDistance(coordinates.get(1)));
    }

}
