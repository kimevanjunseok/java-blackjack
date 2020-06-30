package blackjack.domain.user;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerFactoryTest {

    @ParameterizedTest
    @CsvSource(value = {"pobi,jason:2", "pobi,jason,brown:3"}, delimiter = ':')
    void create(String input, int count) {
        List<Player> players = PlayerFactory.create(input);
        assertThat(players).hasSize(count);
    }
}