package blackjack.domain.user.bettingmoney;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BettingMoneyTest {

    @Test
    void validate_Negative() {
        assertThatThrownBy(() -> BettingMoney.from(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }
}