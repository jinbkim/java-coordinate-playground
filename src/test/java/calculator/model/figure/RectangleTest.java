package calculator.model.figure;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Test;

class RectangleTest {

    @Test
    void 직사각형_넓이_계산하기() {
        List<Integer> positions = Arrays.asList(10, 10, 22, 10, 22, 18, 10, 18);
        Rectangle rectangle = new Rectangle(positions);

        Assertions.assertThat(rectangle.getArea())
            .isEqualTo(96, Offset.offset(0.00099));
    }
}