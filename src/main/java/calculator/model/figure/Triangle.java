package calculator.model.figure;

import calculator.model.Point;
import calculator.view.OutputView;
import java.util.ArrayList;
import java.util.List;

public class Triangle extends AbstractFigure {

    private static final int NUM_OF_TRIANGLE_SIDES = 3;

    public Triangle(List<Integer> positions) {
        super(positions);
        if (!isTriangle()) {
            throw new IllegalArgumentException(OutputView.WRONG_COORDINATE_FORM);
        }
    }

    @Override
    public void printResult() {
        System.out.println(OutputView.TRIANGLE_AREA + getArea());
    }

    public double getArea() {
        Point PointA = getPoints().get(0);
        Point PointB = getPoints().get(1);
        Point PointC = getPoints().get(2);

        return HeronFormula(PointA.getDistance(PointB), PointB.getDistance(PointC), PointC.getDistance(PointA));
    }

    private double HeronFormula(double a, double b, double c) {
        double s = (a + b + c) / 2;

        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    private boolean isTriangle() {
        List<Double> triangleSidesInclinations = getTriangleSidesInclination();

        if (triangleSidesInclinations.stream()
            .distinct()
            .count() == NUM_OF_TRIANGLE_SIDES) {
            return true;
        }
        return false;
    }

    private List<Double> getTriangleSidesInclination() {
        List<Double> triangleSidesInclinations = new ArrayList<>();

        for (int i = 0; i < NUM_OF_TRIANGLE_SIDES; i++) {
            Point pointA = getPoints().get(i % NUM_OF_TRIANGLE_SIDES);
            Point pointB = getPoints().get((i + 1) % NUM_OF_TRIANGLE_SIDES);

            triangleSidesInclinations.add(pointA.getInclination(pointB));
        }
        return triangleSidesInclinations;
    }
}