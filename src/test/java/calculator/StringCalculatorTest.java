package calculator;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class StringCalculatorTest {

    @Nested
    @DisplayName("입력 테스트")
    class input {
        @Test
        @DisplayName("split 테스트")
        void split() {
            String input = "2 + 3 * 4 / 2";
            List<String> expected = Arrays.asList("2", "+", "3", "*", "4", "/", "2");

            StringCalculator calculator = new StringCalculator(input);
            assertThat(calculator.getElements()).containsExactlyElementsOf(expected);
        }

        @Test
        @DisplayName("공백 테스트")
        void blank() {
            String input = "";

            assertThatThrownBy(() -> {
                new StringCalculator(input);
            }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("입력값이 빈칸입니다.");
        }
    }
}
