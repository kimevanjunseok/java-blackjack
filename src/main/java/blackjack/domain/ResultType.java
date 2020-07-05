package blackjack.domain;

import blackjack.domain.user.Dealer;
import blackjack.domain.user.Player;

import java.util.function.BiFunction;

public enum ResultType {
    PLAYER_BLACKJACK_WIN((dealer, player) -> !dealer.isBlackjack() && player.isBlackjack(), 1.5),
    DEALER_BLACKJACK_WIN((dealer, player) -> dealer.isBlackjack() && !player.isBlackjack(), -1),
    BLACKJACK_DRAW((dealer, player) -> dealer.isBlackjack() && player.isBlackjack(), 0),
    PLAYER_BUST_LOSE((dealer, player) -> !dealer.isBust() && player.isBust(), -1),
    DEALER_BUST_LOSE((dealer, player) -> dealer.isBust(), 1),
    PLAYER_WIN((dealer, player) -> player.compareScore(dealer) > 0, 1),
    PLAYER_DRAW((dealer, player) -> player.compareScore(dealer) == 0, 0),
    PLAYER_LOSE((dealer, player) -> player.compareScore(dealer) < 0, -1);

    private final BiFunction<Dealer, Player, Boolean> result;
    private final double earningRate;

    ResultType(BiFunction<Dealer, Player, Boolean> result, double earningRate) {
        this.result = result;
        this.earningRate = earningRate;
    }

    public boolean apply(Dealer dealer, Player player) {
        return result.apply(dealer, player);
    }

    public double getEarningRate() {
        return earningRate;
    }
}
