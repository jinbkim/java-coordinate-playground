package calculator.view;

import calculator.model.Calculator;
import calculator.model.RectangleCalculator;
import calculator.utils.Validator;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final String SPACE_REGEX = "[\\s]";
    private static final String COORDINATE_DELETE_REGEX = "[()]";
    private static final String COORDINATE_SPLIT_REGEX = "[,-]";

    private final Validator validator = new Validator();

    public Calculator requestCoordinate() {
        String input = requestInput(OutputView.REQUEST_COORDINATE);

        return validateCoordinate(input);
    }

    public Calculator validateCoordinate(String input) {
        input = input.replaceAll(SPACE_REGEX, "");
        try {
            List<Integer> coordinates = parseCoordinate(input);

//            validator.validateTwoCoordinate(input);
            //            return new LineCalculator(coordinates);
            validator.validateFourCoordinate(input);
            return new RectangleCalculator(coordinates);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return requestCoordinate();
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
