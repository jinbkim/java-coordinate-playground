package calculator.model.calculator;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Test;

class TriangleCalculatorTest {

    @Test
    void 삼각형의_넓이_계산() {
        List<Integer> coordinates = Arrays.asList(10, 10, 14, 15, 20, 8);
        TriangleCalculator triangleCalculator = new TriangleCalculator(coordinates);

        Assertions.assertThat(triangleCalculator.getArea())
            .isEqualTo(29, Offset.offset(0.00099));
    }
}