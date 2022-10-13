package calculator.view;

import calculator.model.Coordinates;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class InputViewTest {

    private final InputView inputView = new InputView();

    @Test
    void 좌표_정보_파싱하기() {
        Coordinates coordinates = inputView.validateCoordinate("  (  1  ,  2  )  -  (  3  ,  4  )  ");

        Assertions.assertThat(coordinates.isSameSrc(1, 2))
            .isEqualTo(true);
        Assertions.assertThat(coordinates.isSameDst(3, 4))
            .isEqualTo(true);
    }

    @Test
    void 올바른된_좌표_형식인_경우() {
        Assertions.assertThatCode(() -> inputView.validateCoordinate("  (  0  ,  2  )  -  (  3  ,  4  )  "))
            .doesNotThrowAnyException();
    }

    @Test
    void 잘못된_좌표_형식인_경우() {
        Assertions.assertThatThrownBy(() -> inputView.validateCoordinate("  (  1a  ,  2  )  -  (  3  ,  4  )  "));
        Assertions.assertThatThrownBy(() -> inputView.validateCoordinate("  ((  1  ,  2  )  -  (  3  ,  4  )  "));
        Assertions.assertThatThrownBy(() -> inputView.validateCoordinate("  ((  1  ,,  2  )  -  (  3  ,  4  )  "));
        Assertions.assertThatThrownBy(() -> inputView.validateCoordinate("  ((  1  ,  a  )  -  (  3  ,  4  )  "));
        Assertions.assertThatThrownBy(() -> inputView.validateCoordinate("  ((  1  ,  2a  )  -  (  3  ,  4  )  "));
        Assertions.assertThatThrownBy(() -> inputView.validateCoordinate("  ((  1  ,  2-  )  -  (  3  ,  4  )  "));
        Assertions.assertThatThrownBy(() -> inputView.validateCoordinate("  ((  1  ,  2  )   (  3  ,  4  )  "));
        Assertions.assertThatThrownBy(() -> inputView.validateCoordinate("  ((  1  ,  2  )  -  (  3  ,  4,  )  "));
    }

    @Test
    void 좌표값_범위가_잘못된_경우() {
        Assertions.assertThatThrownBy(() -> inputView.validateCoordinate("  ((  25  ,  2  )  -  (  3  ,  4  )  "));
        Assertions.assertThatThrownBy(() -> inputView.validateCoordinate("  ((  1  ,  25  )  -  (  3  ,  4  )  "));
        Assertions.assertThatThrownBy(() -> inputView.validateCoordinate("  ((  1  ,  2  )  -  (  -1  ,  25  )  "));
    }
}