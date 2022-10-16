package calculator.model;

import org.assertj.core.api.Assertions;
import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Test;

class PointTest {

    @Test
    void 선의_길이_계산하기() {
        Point pointA = new Point(10, 10);
        Point pointB = new Point(14, 15);

        Assertions.assertThat(pointA.getDistance(pointB))
            .isEqualTo(6.403124, Offset.offset(0.00099));
    }
}