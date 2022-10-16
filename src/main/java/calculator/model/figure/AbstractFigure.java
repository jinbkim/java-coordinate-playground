package calculator.model.figure;

import calculator.model.Point;
import java.util.ArrayList;
import java.util.List;

public class AbstractFigure implements Figure {

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

    }
}
