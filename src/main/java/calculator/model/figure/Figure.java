package calculator.model.figure;

import calculator.model.Point;
import java.util.List;

public interface Figure {

    List<Point> getPoints();

    boolean hasPoint(int x, int y);

    void printCoordinate();
}
