package blackjack.domain;

import blackjack.domain.user.Dealer;
import blackjack.domain.user.Player;

import java.util.function.BiFunction;

public enum ResultType {
    PLAYER_BLACKJACK_WIN((dealer, player) -> !dealer.isBlackjack() && player.isBlackjack()),
    DEALER_BLACKJACK_WIN((dealer, player) -> dealer.isBlackjack() && !player.isBlackjack()),
    BLACKJACK_DRAW((dealer, player) -> dealer.isBlackjack() && player.isBlackjack()),
    PLAYER_BUST_LOSE((dealer, player) -> !dealer.isBust() && player.isBust()),
    DEALER_BUST_LOSE((dealer, player) -> dealer.isBust()),
    PLAYER_WIN((dealer, player) -> player.compareScore(dealer) > 0),
    PLAYER_DRAW((dealer, player) -> player.compareScore(dealer) == 0),
    PLAYER_LOSE((dealer, player) -> player.compareScore(dealer) < 0);

    private final BiFunction<Dealer, Player, Boolean> result;

    ResultType(BiFunction<Dealer, Player, Boolean> result) {
        this.result = result;
    }

    public boolean apply(Dealer dealer, Player player) {
        return result.apply(dealer, player);
    }
}
