package calculator.view;

import calculator.model.Coordinates;
import calculator.utils.Validator;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final String SPACE_REGEX = "[\\s]";
    private static final String COORDINATE_DELETE_REGEX = "[()]";
    private static final String COORDINATE_SPLIT_REGEX = "[,-]";

    private final Validator inputValidator = new Validator();

    public Coordinates requestCoordinate() {
        String input = requestInput(OutputView.REQUEST_COORDINATE);

        return validateCoordinate(input);
    }

    public Coordinates validateCoordinate(String input) {
        input = input.replaceAll(SPACE_REGEX, "");
        try {
            inputValidator.validateCoordinateInput(input);
            return parseCoordinateInput(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return requestCoordinate();
        }
    }

    private Coordinates parseCoordinateInput(String input) {
        input = input.replaceAll(COORDINATE_DELETE_REGEX, "");
        List<Integer> coordinates = Arrays.stream(input.split(COORDINATE_SPLIT_REGEX))
            .map(Integer::parseInt)
            .collect(Collectors.toList());

        return new Coordinates(coordinates);
    }

    private String requestInput(String input) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(input);
        return scanner.nextLine();
    }
}
