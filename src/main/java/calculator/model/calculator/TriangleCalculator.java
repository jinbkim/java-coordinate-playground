package calculator.model.calculator;

import calculator.model.Coordinate;
import calculator.view.OutputView;
import java.util.List;

public class TriangleCalculator extends Calculator {

    public TriangleCalculator(List<Integer> coordinates) {
        super(coordinates);
        if (!isTriangle()) {
            throw new IllegalArgumentException(OutputView.WRONG_COORDINATE);

        }
    }

    public void printResult() {
        System.out.println(OutputView.TRIANGLE_AREA + getArea());
    }

    public double getArea() {
        Coordinate coordinateA = coordinates.get(0);
        Coordinate coordinateB = coordinates.get(1);
        Coordinate coordinateC = coordinates.get(2);

        return HeronFormula(coordinateA.getLineDistance(coordinateB), coordinateB.getLineDistance(coordinateC), coordinateC.getLineDistance(coordinateA));
    }

    private double HeronFormula(double a, double b, double c) {
        double s = (a + b + c) / 2;

        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    private boolean isTriangle() {
        Coordinate baseCoordinate = coordinates.get(0);
        Coordinate coordinateA = coordinates.get(1);
        Coordinate coordinateB = coordinates.get(2);

        if (baseCoordinate.getInclination(coordinateA) == baseCoordinate.getInclination(coordinateB)) {
            return false;
        }
        return true;
    }
}
