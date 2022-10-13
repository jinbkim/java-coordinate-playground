package calculator.model;

import org.assertj.core.api.Assertions;
import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Test;

class CoordinateTest {

    @Test
    void 선_길이_계산하기() {
        Coordinate src = new Coordinate(10, 10);
        Coordinate dst = new Coordinate(14, 15);

        Assertions.assertThat(src.getLineDistance(dst))
            .isEqualTo(6.403124, Offset.offset(0.00099));
    }
}