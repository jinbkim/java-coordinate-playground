package calculator.controller;

import calculator.view.InputView;

public class Calculator {

    private final InputView inputView = new InputView();

    public void run() {
        inputView.requestCoordinate();
    }
}
