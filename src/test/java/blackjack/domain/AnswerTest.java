package blackjack.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class AnswerTest {

    @ParameterizedTest
    @CsvSource(value = {"Y:YES", "y:YES", "N:NO", "n:NO"}, delimiter = ':')
    void find(String input, Answer expect) {
        assertThat(Answer.find(input)).isEqualTo(expect);
    }

    @ParameterizedTest
    @ValueSource(strings = {"q", "1", "asd"})
    void find_Exception(String input) {
        assertThatThrownBy(() -> Answer.find(input))
                .isInstanceOf(IllegalArgumentException.class);
    }


}