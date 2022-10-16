package calculator.view;

import calculator.model.Figure;
import calculator.model.FigureFactory;
import java.util.Scanner;
import java.util.regex.Pattern;

public class InputView {

    private static final String SPACE_REGEX = "[\\s]";
    private static final String LINE_COORDINATE_REGEX = "^\\([0-9]+,[0-9]+\\)-\\([0-9]+,[0-9]+\\)$";
    private static final String RECTANGLE_COORDINATE_REGEX = "^\\([0-9]+,[0-9]+\\)-\\([0-9]+,[0-9]+\\)-\\([0-9]+,[0-9]+\\)-\\([0-9]+,[0-9]+\\)$";
    private static final String TRIANGLE_COORDINATE_REGEX = "^\\([0-9]+,[0-9]+\\)-\\([0-9]+,[0-9]+\\)-\\([0-9]+,[0-9]+\\)$";

    public Figure requestCoordinate() {
        String input = requestInput(OutputView.REQUEST_COORDINATE);

        try {
            input = validateCoordinateForm(input);
            return FigureFactory.create(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return requestCoordinate();
        }
    }

    public String validateCoordinateForm(String input) {
        input = input.replaceAll(SPACE_REGEX, "");
        if (isLine(input) || isTriangle(input) || isRectangle(input)) {
            return input;
        }
        throw new IllegalArgumentException(OutputView.WRONG_COORDINATE_FORM);
    }

    private boolean isLine(String input) {
        if (Pattern.matches(LINE_COORDINATE_REGEX, input)) {
            return true;
        }
        return false;
    }

    private boolean isTriangle(String input) {
        if (Pattern.matches(TRIANGLE_COORDINATE_REGEX, input)) {
            return true;
        }
        return false;
    }

    private boolean isRectangle(String input) {
        if (Pattern.matches(RECTANGLE_COORDINATE_REGEX, input)) {
            return true;
        }
        return false;
    }

    private String requestInput(String input) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(input);
        return scanner.nextLine();
    }
}
