package calculator.view;

import calculator.model.Coordinate;
import calculator.model.Coordinates;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class InputViewTest {

    private final InputView inputView = new InputView();

    @Test
    void 좌표_정보_파싱하기() {
        Coordinates coordinates = inputView.parseCoordinateInput("  (  1  ,  2  )  -  (  3  ,  4  )  ");
        Coordinate src = coordinates.getSrc();
        Coordinate dst = coordinates.getDst();

        Assertions.assertThat(src.getX()
                .get())
            .isEqualTo(1);
        Assertions.assertThat(src.getY()
                .get())
            .isEqualTo(2);
        Assertions.assertThat(dst.getX()
                .get())
            .isEqualTo(3);
        Assertions.assertThat(dst.getY()
                .get())
            .isEqualTo(4);
    }
}