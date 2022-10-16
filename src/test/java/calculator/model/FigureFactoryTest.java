package calculator.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class FigureFactoryTest {

    @Test
    void 입력값에_따라_올바른_객체_생성하기() {
        Figure line = FigureFactory.create("(1,1)-(2,2)");
        Figure triangle = FigureFactory.create("(1,1)-(2,2)-(2,1)");
        Figure rectangle = FigureFactory.create("(1,1)-(1,2)-(2,1)-(2,2)");

        Assertions.assertThat(line instanceof Line)
            .isTrue();
        Assertions.assertThat(triangle instanceof Triangle)
            .isTrue();
        Assertions.assertThat(rectangle instanceof Rectangle)
            .isTrue();
    }

    @Test
    void 좌표_정보_파싱하기() {
        Figure line = FigureFactory.create("(1,1)-(2,2)");
        Figure triangle = FigureFactory.create("(1,1)-(2,2)-(2,1)");
        Figure rectangle = FigureFactory.create("(1,1)-(1,2)-(2,1)-(2,2)");

        Assertions.assertThat(line.hasPoint(1, 1))
            .isEqualTo(true);
        Assertions.assertThat(line.hasPoint(2, 2))
            .isEqualTo(true);

        Assertions.assertThat(triangle.hasPoint(1, 1))
            .isEqualTo(true);
        Assertions.assertThat(triangle.hasPoint(2, 2))
            .isEqualTo(true);
        Assertions.assertThat(triangle.hasPoint(2, 1))
            .isEqualTo(true);

        Assertions.assertThat(rectangle.hasPoint(1, 1))
            .isEqualTo(true);
        Assertions.assertThat(rectangle.hasPoint(1, 2))
            .isEqualTo(true);
        Assertions.assertThat(rectangle.hasPoint(2, 1))
            .isEqualTo(true);
        Assertions.assertThat(rectangle.hasPoint(2, 2))
            .isEqualTo(true);
    }

    @Test
    void 입력값에서_좌표가_2개일때_선이_아닌_경우() {
        Assertions.assertThatThrownBy(() -> FigureFactory.create("(1,1)-(1,1)"));
    }

    @Test
    void 입력값에서_좌표가_3개일때_삼각형이_아닌_경우() {
        Assertions.assertThatThrownBy(() -> FigureFactory.create("(1,1)-(1,1)-(2,1)"));
        Assertions.assertThatThrownBy(() -> FigureFactory.create("(1,1)-(2,2)-(3,3)"));
    }

    @Test
    void 입력값에서_좌표가_4개일때_직사각형이_아닌_경우() {
        Assertions.assertThatThrownBy(() -> FigureFactory.create("(1,1)-(1,1)-(2,2)-(3,4)"));
        Assertions.assertThatThrownBy(() -> FigureFactory.create("(1,1)-(2,2)-(3,3)-(4,5)"));
        Assertions.assertThatThrownBy(() -> FigureFactory.create("(1,2)-(3,6)-(7,5)-(9,3)"));
        Assertions.assertThatThrownBy(() -> FigureFactory.create("(1,1)-(2,1)-(2,2)-(3,3)"));
    }

    @Test
    void 좌표값이_24_초과인_경우() {
        Assertions.assertThatThrownBy(() -> FigureFactory.create("(1,1)-(25,1))"));
        Assertions.assertThatThrownBy(() -> FigureFactory.create("(1,1)-(25,1)-(2,2)"));
        Assertions.assertThatThrownBy(() -> FigureFactory.create("(1,1)-(1,2)-(2,2)-(25,4)"));
    }
}