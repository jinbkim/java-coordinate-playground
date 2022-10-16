package calculator.view;

import calculator.model.Figure;
import calculator.model.FigureFactory;
import java.util.Scanner;

public class InputView {

    public Figure requestCoordinate() {
        String input = requestInput(OutputView.REQUEST_COORDINATE);
        return FigureFactory.create(input);
    }

    private String requestInput(String input) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(input);
        return scanner.nextLine();
    }
}
