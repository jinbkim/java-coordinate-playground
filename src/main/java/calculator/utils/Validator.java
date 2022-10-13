package calculator.utils;

import calculator.view.OutputView;
import java.util.regex.Pattern;

public class Validator {

    private static final String COORDINATE_REGEX = "^\\([0-9]+,[0-9]+\\)-\\([0-9]+,[0-9]+\\)$";
    private static final int COORDINATE_RANGE_MAX = 24;


    public void validateCoordinateInput(String coordinateInput) {
        if (!Pattern.matches(COORDINATE_REGEX, coordinateInput)) {
            throw new IllegalArgumentException(OutputView.WRONG_COORDINATE);
        }
    }

    public void validateCoordinateRange(int position) {
        if (position > COORDINATE_RANGE_MAX) {
            throw new IllegalArgumentException();
        }
    }
}
