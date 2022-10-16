package calculator.model.figure;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Test;

class TriangleTest {

    @Test
    void 삼각형_넓이_계산하기() {
        List<Integer> positions = Arrays.asList(10, 10, 14, 15, 20, 8);
        Triangle triangle = new Triangle(positions);

        Assertions.assertThat(triangle.getArea())
            .isEqualTo(29, Offset.offset(0.00099));
    }
}