package calculator.view;

import java.util.Scanner;

public class InputView {

    public void requestCoordinate() {
        requestInput(OutputView.REQUEST_COORDINATE);
    }

    private String requestInput(String input) {
        System.out.println(input);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
