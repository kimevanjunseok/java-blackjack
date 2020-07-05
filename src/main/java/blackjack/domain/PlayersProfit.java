package blackjack.domain;

import blackjack.domain.user.Dealer;
import blackjack.domain.user.Player;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayersProfit {

    private final Map<Player, Double> profits;

    private PlayersProfit(Map<Player, Double> profits) {
        this.profits = profits;
    }

    public static PlayersProfit from(Dealer dealer, List<Player> players) {
        Map<Player, Double> profits = new HashMap<>();
        for (Player player : players) {
            ResultType type = ResultType.find(dealer, player);
            profits.put(player, player.profit(type));
        }
        return new PlayersProfit(profits);
    }
}
