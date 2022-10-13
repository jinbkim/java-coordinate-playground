package calculator.controller;

import calculator.model.Coordinates;
import calculator.view.InputView;

public class Calculator {

    private final InputView inputView = new InputView();

    public void run() {
        Coordinates coordinates = inputView.requestCoordinate();
        coordinates.printCoordinate();
        coordinates.printDistance();
    }
}
