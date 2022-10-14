package calculator.view;

import calculator.model.calculator.Calculator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class InputViewTest {

    private final InputView inputView = new InputView();

    @Test
    void 좌표_정보_파싱하기() {
        //        Calculator lineCalculator = inputView.validateCoordinate("  (  1  ,  2  )  -  (  3  ,  4  )  ");
        Calculator rectangleCalculator = inputView.validateCoordinate("  (  1  ,  1  )  -  (  1  ,  10  )  -  (  10  ,  1  )  -  (  10  ,  10  )  ");

        //        Assertions.assertThat(lineCalculator.isPoint(1, 2))
        //            .isEqualTo(true);
        //        Assertions.assertThat(lineCalculator.isPoint(3, 4))
        //            .isEqualTo(true);

        Assertions.assertThat(rectangleCalculator.isPoint(1, 1))
            .isEqualTo(true);
        Assertions.assertThat(rectangleCalculator.isPoint(1, 10))
            .isEqualTo(true);
        Assertions.assertThat(rectangleCalculator.isPoint(10, 1))
            .isEqualTo(true);
        Assertions.assertThat(rectangleCalculator.isPoint(10, 10))
            .isEqualTo(true);
    }

    @Test
    void 올바른된_좌표_형식인_경우() {
        //        Assertions.assertThatCode(() -> inputView.validateCoordinate("  (  0  ,  2  )  -  (  3  ,  4  )  "))
        //            .doesNotThrowAnyException();
        Assertions.assertThatCode(() -> inputView.validateCoordinate("  (  1  ,  1  )  -  (  1  ,  10  )  -  (  10  ,  1  )  -  (  10  ,  10  )  "))
            .doesNotThrowAnyException();
    }

    @Test
    void 잘못된_좌표_형식인_경우() {
        //        Assertions.assertThatThrownBy(() -> inputView.validateCoordinate("  (  1a  ,  2  )  -  (  3  ,  4  )  "));
        //        Assertions.assertThatThrownBy(() -> inputView.validateCoordinate("  ((  1  ,  2  )  -  (  3  ,  4  )  "));
        //        Assertions.assertThatThrownBy(() -> inputView.validateCoordinate("  ((  1  ,,  2  )  -  (  3  ,  4  )  "));
        //        Assertions.assertThatThrownBy(() -> inputView.validateCoordinate("  ((  1  ,  a  )  -  (  3  ,  4  )  "));
        //        Assertions.assertThatThrownBy(() -> inputView.validateCoordinate("  ((  1  ,  2a  )  -  (  3  ,  4  )  "));
        //        Assertions.assertThatThrownBy(() -> inputView.validateCoordinate("  ((  1  ,  2-  )  -  (  3  ,  4  )  "));
        //        Assertions.assertThatThrownBy(() -> inputView.validateCoordinate("  ((  1  ,  2  )   (  3  ,  4  )  "));
        //        Assertions.assertThatThrownBy(() -> inputView.validateCoordinate("  ((  1  ,  2  )  -  (  3  ,  4,  )  "));

        Assertions.assertThatThrownBy(() -> inputView.validateCoordinate("  (  1a  ,  2  )  -  (  3  ,  4  )  -  (  5  ,  6  )  -  (  7  ,  8  )  "));
        Assertions.assertThatThrownBy(() -> inputView.validateCoordinate("  (  1  ,  2  )  -  (  3  ,  b  )  -  (  5  ,  6  )  -  (  7  ,  8  )  "));
        Assertions.assertThatThrownBy(() -> inputView.validateCoordinate("  (  1  ,  2  ),  -  (  3  ,  4  )  -  (  5  ,  6  )  -  (  7  ,  8  )  "));
        Assertions.assertThatThrownBy(() -> inputView.validateCoordinate("  (  1  ,  2  )  -  (  3  ,  4  )  -  (  5    6  )  -  (  7  ,  8  )  "));
        Assertions.assertThatThrownBy(() -> inputView.validateCoordinate("  (  1  ,  2  )  -  (  3  ,  4  )  -  (  5  ,  6  )  -  (  7  ,,  8  )  "));
        Assertions.assertThatThrownBy(() -> inputView.validateCoordinate("  (  1  ,  2  )  --  (  3  ,  4  )  -  (  5  ,  6  )  -  (  7  ,  8  )  "));
        Assertions.assertThatThrownBy(() -> inputView.validateCoordinate("  (  1  ,  2  )  -  (  3  ,  4  )  -  ((  5  ,  6  )  -  (  7  ,  8  )  "));
        Assertions.assertThatThrownBy(() -> inputView.validateCoordinate("  (  1  ,  2  ))  -  (  3  ,  4  )  -  (  5  ,  6  )  -  (  7  ,  8  )  "));
        Assertions.assertThatThrownBy(() -> inputView.validateCoordinate("  !(  1  ,  2  )  -  (  3  ,  4  )  -  (  5  ,  6  )  -  (  7  ,  8  )  "));
        Assertions.assertThatThrownBy(() -> inputView.validateCoordinate("  (  1  ,  2  )  -  (  3  ,  4  )  -  (  5  ,  6  )  -  (  7  ,  8  )  "));

    }

    @Test
    void 좌표값_범위가_잘못된_경우() {
        //        Assertions.assertThatThrownBy(() -> inputView.validateCoordinate("  ((  25  ,  2  )  -  (  3  ,  4  )  "));
        //        Assertions.assertThatThrownBy(() -> inputView.validateCoordinate("  ((  1  ,  25  )  -  (  3  ,  4  )  "));
        //        Assertions.assertThatThrownBy(() -> inputView.validateCoordinate("  ((  1  ,  2  )  -  (  -1  ,  25  )  "));

        Assertions.assertThatThrownBy(() -> inputView.validateCoordinate("  (  25  ,  2  )  -  (  3  ,  4  )  -  (  5  ,  6  )  -  (  7  ,  8  )  "));
        Assertions.assertThatThrownBy(() -> inputView.validateCoordinate("  (  1  ,  2  )  -  (  -3  ,  4  )  -  (  5  ,  6  )  -  (  7  ,  8  )  "));
        Assertions.assertThatThrownBy(() -> inputView.validateCoordinate("  (  25  ,  2  )  -  (  3  ,  4  )  -  (  25  ,  6  )  -  (  7  ,  8  )  "));
        Assertions.assertThatThrownBy(() -> inputView.validateCoordinate("  (  25  ,  2  )  -  (  3  ,  4  )  -  (  5  ,  6  )  -  (  7  ,  28  )  "));
    }
}