package calculator.view;

import calculator.model.calculator.Calculator;
import calculator.model.calculator.TriangleCalculator;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputView {

    private static final String SPACE_REGEX = "[\\s]";
    private static final String COORDINATE_DELETE_REGEX = "[()]";
    private static final String COORDINATE_SPLIT_REGEX = "[,-]";
    private static final String LINE_COORDINATE_REGEX = "^\\([0-9]+,[0-9]+\\)-\\([0-9]+,[0-9]+\\)$";
    private static final String RECTANGLE_COORDINATE_REGEX = "^\\([0-9]+,[0-9]+\\)-\\([0-9]+,[0-9]+\\)-\\([0-9]+,[0-9]+\\)-\\([0-9]+,[0-9]+\\)$";
    private static final String TRIANGLE_COORDINATE_REGEX = "^\\([0-9]+,[0-9]+\\)-\\([0-9]+,[0-9]+\\)-\\([0-9]+,[0-9]+\\)$";

    public Calculator requestCoordinate() {
        String input = requestInput(OutputView.REQUEST_COORDINATE);

        return validateCoordinate(input);
    }

    public Calculator validateCoordinate(String input) {
        input = input.replaceAll(SPACE_REGEX, "");
        try {
            List<Integer> coordinates = parseCoordinate(input);
            //            validateTwoCoordinate(input);
            //            return new LineCalculator(coordinates);
            //            validateFourCoordinate(input);
            //            return new RectangleCalculator(coordinates);
            validateThreeCoordinate(input);
            return new TriangleCalculator(coordinates);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return requestCoordinate();
        }
    }

    private void validateTwoCoordinate(String coordinateInput) {
        if (!Pattern.matches(LINE_COORDINATE_REGEX, coordinateInput)) {
            throw new IllegalArgumentException(OutputView.WRONG_COORDINATE);
        }
    }

    private void validateFourCoordinate(String coordinateInput) {
        if (!Pattern.matches(RECTANGLE_COORDINATE_REGEX, coordinateInput)) {
            throw new IllegalArgumentException(OutputView.WRONG_COORDINATE);
        }
    }

    private void validateThreeCoordinate(String coordinateInput) {
        if (!Pattern.matches(TRIANGLE_COORDINATE_REGEX, coordinateInput)) {
            throw new IllegalArgumentException(OutputView.WRONG_COORDINATE);
        }
    }

    private List<Integer> parseCoordinate(String input) {
        input = input.replaceAll(COORDINATE_DELETE_REGEX, "");
        return Arrays.stream(input.split(COORDINATE_SPLIT_REGEX))
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }

    private String requestInput(String input) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(input);
        return scanner.nextLine();
    }
}
