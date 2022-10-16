package calculator.view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class InputViewTest {

    private final InputView inputView = new InputView();

    @Test
    void 입력값이_선_또는_삼각형_또는_직사각형의_형식인_경우() {
        Assertions.assertThatCode(() -> inputView.validateCoordinateForm(" ( 1 , 1 ) - ( 2 , 2 ) "))
            .doesNotThrowAnyException();
        Assertions.assertThatCode(() -> inputView.validateCoordinateForm(" ( 1 , 1 ) - ( 2 , 2 ) - ( 2 , 1 ) "))
            .doesNotThrowAnyException();
        Assertions.assertThatCode(() -> inputView.validateCoordinateForm(" ( 1 , 1 ) - ( 1 , 2 ) - ( 2 , 1 ) - ( 2 , 2 ) "))
            .doesNotThrowAnyException();
    }

    @Test
    void 입력값이_선_또는_삼각형_또는_직사각형의_형식이_아닌_경우() {
        Assertions.assertThatThrownBy(() -> inputView.validateCoordinateForm("(1,1)"));
        Assertions.assertThatThrownBy(() -> inputView.validateCoordinateForm("(1,1)-(2,a)"));
        Assertions.assertThatThrownBy(() -> inputView.validateCoordinateForm("(1,1)-(2,3)-(3,1c)"));
        Assertions.assertThatThrownBy(() -> inputView.validateCoordinateForm("(1,1)-(2,1)-(1,2)-(2,2))"));
        Assertions.assertThatThrownBy(() -> inputView.validateCoordinateForm("(1,,1)-(2,1)-(1,2)-(2,2)"));
        Assertions.assertThatThrownBy(() -> inputView.validateCoordinateForm("(1,1)-(2,1)-(1,2)a-(2,2)"));
        Assertions.assertThatThrownBy(() -> inputView.validateCoordinateForm("(1,1-)-(2,1)-(1,2)-(2,2)"));
        Assertions.assertThatThrownBy(() -> inputView.validateCoordinateForm("(1,1)-(2,1)--(1,2)-(2,2)"));
        Assertions.assertThatThrownBy(() -> inputView.validateCoordinateForm("(,1)-(2,1)-(1,2)-(2,2)"));
    }
}