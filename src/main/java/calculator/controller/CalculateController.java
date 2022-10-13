package calculator.controller;

import calculator.model.LineCalculator;
import calculator.view.InputView;

public class CalculateController {

    private final InputView inputView = new InputView();

    public void run() {
        LineCalculator lineCalculator = inputView.requestCoordinate();
        lineCalculator.printCoordinate();
        lineCalculator.printDistance();
    }
}
