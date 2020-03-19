
package model.user;

import model.card.Card;
import model.card.Symbol;
import model.card.Type;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static model.user.Dealer.DEALER_NAME;
import static org.assertj.core.api.Assertions.assertThat;

public class BlackJackGameUserTest {
    public static final String PLAYER_NAME = "DD";

    private Player bustPlayer = new Player(PLAYER_NAME, Arrays.asList(
        new Card(Symbol.KING, Type.DIAMOND),
        new Card(Symbol.QUEEN, Type.DIAMOND),
        new Card(Symbol.TWO, Type.DIAMOND)
    ));
    private Player notBustPlayer = new Player(PLAYER_NAME, Arrays.asList(
        new Card(Symbol.KING, Type.DIAMOND),
        new Card(Symbol.QUEEN, Type.DIAMOND)
    ));
    private Player blackJackPlayer = new Player(PLAYER_NAME, Arrays.asList(
        new Card(Symbol.QUEEN, Type.CLUB),
        new Card(Symbol.ACE, Type.HEART)
    ));
    private Dealer bustDealer = new Dealer(Arrays.asList(
        new Card(Symbol.KING, Type.DIAMOND),
        new Card(Symbol.QUEEN, Type.DIAMOND),
        new Card(Symbol.TWO, Type.DIAMOND)
    ));
    private Dealer notBustDealer = new Dealer(Arrays.asList(
        new Card(Symbol.KING, Type.DIAMOND),
        new Card(Symbol.QUEEN, Type.DIAMOND),
        new Card(Symbol.ACE, Type.DIAMOND)
    ));

    @Test
    @DisplayName("딜러 이름 테스트")
    void dealer_Name() {
        assertThat(notBustDealer.getName()).isEqualTo(DEALER_NAME);
    }

    @Test
    @DisplayName("이름을 불러오는 지 테스트")
    void name_Test() {
        assertThat(notBustPlayer.getName()).isEqualTo(PLAYER_NAME);
    }

    @Test
    @DisplayName("bust 테스트")
    void isBustTest() {
        assertThat(bustDealer.isBust()).isTrue();
        assertThat(bustPlayer.isBust()).isTrue();
        assertThat(blackJackPlayer.isBust()).isFalse();
        assertThat(notBustPlayer.isBust()).isFalse();
        assertThat(notBustDealer.isBust()).isFalse();
    }

    @Test
    @DisplayName("blackjack 테스트")
    void isBlackJackTest() {
        assertThat(notBustPlayer.isBlackJack()).isFalse();
        assertThat(blackJackPlayer.isBlackJack()).isTrue();
        assertThat(bustPlayer.isBlackJack()).isFalse();
    }

    @Test
    @DisplayName("moreThanBlackjack 테스트")
    void isMoreThanBlackJackTest() {
        assertThat(notBustPlayer.isOverBlackJack()).isFalse();
        assertThat(blackJackPlayer.isOverBlackJack()).isTrue();
        assertThat(bustPlayer.isOverBlackJack()).isTrue();
    }
}