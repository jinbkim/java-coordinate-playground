package calculator.model;

import calculator.view.OutputView;
import java.util.List;

public class LineCalculator {

    private final static int COORDINATE_RANGE_MAX = 24;
    private final static String VERTICAL_LINE = "┃";
    private final static String HORIZONTAL_LINE = "━━━";
    private final static String CENTER = "0";
    private final static String MARK = "@";

    private final Coordinate src;
    private final Coordinate dst;

    public LineCalculator(List<Integer> coordinates) {
        src = new Coordinate(coordinates.get(0), coordinates.get(1));
        dst = new Coordinate(coordinates.get(2), coordinates.get(3));
    }

    public boolean isSameSrc(int x, int y) {
        return src.isSameX(x) && src.isSameY(y);
    }

    public boolean isSameDst(int x, int y) {
        return dst.isSameX(x) && dst.isSameY(y);
    }

    public void printCoordinate() {
        printVerticalLineAndYCoordinateAndPoints();
        printHorizontalLine();
        printXCoordinate();
    }

    public void printDistance() {
        System.out.println(OutputView.LINE_DISTANCE + src.getLineDistance(dst));
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
            if (!(src.isSameX(x) && src.isSameY(y) || dst.isSameX(x) && dst.isSameY(y))) {
                System.out.print("   ");
                continue;
            }
            System.out.print(MARK);
            break;
        }
        System.out.println();
    }
}
