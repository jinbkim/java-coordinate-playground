package calculator.model;

import java.util.ArrayList;
import java.util.List;

public class AbstractFigure implements Figure {

    private final List<Point> points;

    public AbstractFigure(List<Integer> points) {
        this.points = new ArrayList<>();
        for (int i = 0; i < points.size(); i += 2) {
            this.points.add(new Point(points.get(i), points.get(i + 1)));
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
