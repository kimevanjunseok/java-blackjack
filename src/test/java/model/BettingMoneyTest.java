package model;

import exception.IllegalBettingMoneyFormatException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BettingMoneyTest {

    @ParameterizedTest
    @ValueSource(strings = {"a", "안녕하세요", ",;'"})
    void validate_String_test(String input) {
        assertThatThrownBy(()->new BettingMoney(input))
                .isInstanceOf(IllegalBettingMoneyFormatException.class)
                .hasMessageMatching("배팅 금액은 100이상의 숫자만 입력 가능합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "0" , "99"})
    void validate_Range_Test(String input) {
        assertThatThrownBy(() -> new BettingMoney(input))
                .isInstanceOf(IllegalBettingMoneyFormatException.class)
                .hasMessageMatching("배팅 금액은 100이상의 숫자만 입력 가능합니다.");
    }
}
