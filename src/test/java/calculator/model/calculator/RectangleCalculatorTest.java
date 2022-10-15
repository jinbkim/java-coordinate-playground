package calculator.model.calculator;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Test;

class RectangleCalculatorTest {

    @Test
    void 직사각형의_넓이_계산() {
        List<Integer> coordinates = Arrays.asList(10, 10, 22, 10, 22, 18, 10, 18);
        RectangleCalculator rectangleCalculator = new RectangleCalculator(coordinates);

        Assertions.assertThat(rectangleCalculator.getArea())
            .isEqualTo(96, Offset.offset(0.00099));
    }
}