package calculator.view;

import calculator.model.Coordinates;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final String COORDINATE_DELETE_REGEX = "[()]";
    private static final String COORDINATE_SPLIT_REGEX = "[,-]";

    public void requestCoordinate() {
        String input = requestInput(OutputView.REQUEST_COORDINATE);
        Coordinates coordinates = parseCoordinateInput(input);
    }

    public Coordinates parseCoordinateInput(String input) {
        input = input.replaceAll(COORDINATE_DELETE_REGEX, "");
        List<Integer> coordinates = Arrays.stream(input.split(COORDINATE_SPLIT_REGEX))
            .map(String::trim)
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
