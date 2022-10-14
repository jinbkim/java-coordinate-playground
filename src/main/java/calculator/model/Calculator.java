package calculator.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Calculator {

    private final static int COORDINATE_RANGE_MAX = 24;
    private final static String VERTICAL_LINE = "┃";
    private final static String HORIZONTAL_LINE = "━━━";
    private final static String CENTER = "0";
    private final static String MARK = "@";

    protected final List<Coordinate> coordinates;

    public Calculator(List<Integer> coordinates) {
        this.coordinates = new ArrayList<>();
        for (int i = 0; i < coordinates.size(); i += 2) {
            this.coordinates.add(new Coordinate(coordinates.get(i), coordinates.get(i + 1)));
        }
    }

    public void printCoordinate() {
        printVerticalLineAndYCoordinateAndPoints();
        printHorizontalLine();
        printXCoordinate();
        printResult();
    }

    public boolean isPoint(int x, int y) {
        for (Coordinate coordinate : coordinates) {
            if (coordinate.isSameX(x) && coordinate.isSameY(y)) {
                return true;
            }
        }
        return false;
    }

    private void printXCoordinate() {
        System.out.print(" " + CENTER + "  ");
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
            if (!isPoint(x, y)) {
                System.out.print("   ");
                continue;
            }
            System.out.print(MARK);
        }
        System.out.println();
    }

    abstract public void printResult();
}
