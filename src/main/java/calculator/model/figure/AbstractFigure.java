package calculator.model.figure;

import calculator.model.Point;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractFigure implements Figure {

    private final static int COORDINATE_RANGE_MAX = 24;
    private final static String COORDINATE_CENTER = "0";
    private final static String VERTICAL_LINE = "┃";
    private final static String HORIZONTAL_LINE = "━━━";
    private final static String MARK = "@";

    protected final List<Point> points;

    public AbstractFigure(List<Integer> positions) {
        points = new ArrayList<>();
        for (int i = 0; i < positions.size(); i += 2) {
            points.add(new Point(positions.get(i), positions.get(i + 1)));
        }
    }

    @Override
    public List<Point> getPoints() {
        return null;
    }

    @Override
    public boolean hasPoint(int x, int y) {
        if (points.stream()
            .filter(point -> point.isPoint(x, y))
            .count() == 0) {
            return false;
        }
        return true;
    }

    @Override
    public void printCoordinate() {
        printVerticalLineAndYCoordinateAndPoints();
        printHorizontalLine();
        printXCoordinate();
        printResult();
    }

    private void printXCoordinate() {
        System.out.print(" " + COORDINATE_CENTER + "  ");
        for (int i = 1; i <= COORDINATE_RANGE_MAX; i++) {
            System.out.print(String.format("%3s", i));
        }
        System.out.println("\n");
    }

    private void printHorizontalLine() {
        System.out.print("   ");
        for (int x = 0; x < COORDINATE_RANGE_MAX; x++) {
            System.out.print(HORIZONTAL_LINE);
        }
        System.out.println();
    }

    private void printVerticalLineAndYCoordinateAndPoints() {
        for (int y = COORDINATE_RANGE_MAX; y > 0; y--) {
            printVerticalLineAndYCoordinate(y);
            printPoints(y);
        }
        System.out.println("  " + VERTICAL_LINE);
    }

    private void printVerticalLineAndYCoordinate(int y) {
        System.out.print(String.format("%3s", y + VERTICAL_LINE));
    }

    private void printPoints(int y) {
        for (int x = 0; x <= COORDINATE_RANGE_MAX; x++) {
            if (!hasPoint(x, y)) {
                System.out.print("   ");
                continue;
            }
            System.out.print(MARK);
        }
        System.out.println();
    }

    abstract public void printResult();
}
