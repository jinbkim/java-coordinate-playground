package calculator.controller;

import calculator.model.figure.Figure;
import calculator.view.InputView;

public class CalculatorController {

    private final InputView inputView = new InputView();

    public void run() {
        Figure figure = inputView.requestCoordinate();
        figure.printCoordinate();
    }
}
