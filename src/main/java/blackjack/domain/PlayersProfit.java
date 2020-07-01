package blackjack.domain;

import blackjack.domain.user.Player;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayersProfit {

    private final Map<Player, Integer> profits;

    private PlayersProfit(Map<Player, Integer> profits) {
        this.profits = profits;
    }

    public static PlayersProfit from(List<Player> players) {
        Map<Player, Integer> profits = new HashMap<>();
        for (Player player : players) {
            profits.put(player, 0);
        }
        return new PlayersProfit(profits);
    }
}
