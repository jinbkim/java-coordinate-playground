package calculator.controller;

import calculator.model.Calculator;
import calculator.view.InputView;

public class CalculateController {

    private final InputView inputView = new InputView();

    public void run() {
        Calculator calculator = inputView.requestCoordinate();
        calculator.printCoordinate();
    }
}
