package calculator.model;

import calculator.model.figure.Figure;
import calculator.model.figure.Line;
import calculator.model.figure.Rectangle;
import calculator.model.figure.Triangle;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FigureFactory {

    private static final int NUM_OF_POS_IN_LINE = 4;
    private static final int NUM_OF_POS_IN_TRIANGLE = 6;
    private static final int NUM_OF_POS_IN_RECTANGLE = 8;

    private static final String COORDINATE_DELETE_REGEX = "[()]";
    private static final String COORDINATE_SPLIT_REGEX = "[,-]";

    private static final Map<Integer, Function<List<Integer>, Figure>> figureRecipe = new HashMap<>();

    static {
        figureRecipe.put(NUM_OF_POS_IN_LINE, Line::new);
        figureRecipe.put(NUM_OF_POS_IN_TRIANGLE, Triangle::new);
        figureRecipe.put(NUM_OF_POS_IN_RECTANGLE, Rectangle::new);
    }

    public static Figure create(String input) {
        List<Integer> positions = parseCoordinate(input);
        Function<List<Integer>, Figure> figureConstructor = figureRecipe.get(positions.size());

        return figureConstructor.apply(positions);
    }

    private static List<Integer> parseCoordinate(String input) {
        input = input.replaceAll(COORDINATE_DELETE_REGEX, "");
        return Arrays.stream(input.split(COORDINATE_SPLIT_REGEX))
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }
}
