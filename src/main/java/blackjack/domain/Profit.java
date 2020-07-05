package blackjack.domain;

import blackjack.domain.user.Dealer;
import blackjack.domain.user.Player;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Profit {

    private final Map<Player, Double> profits;

    private Profit(Map<Player, Double> profits) {
        this.profits = profits;
    }

    public static Profit from(Dealer dealer, List<Player> players) {
        Map<Player, Double> profits = new HashMap<>();
        for (Player player : players) {
            ResultType type = ResultType.find(dealer, player);
            profits.put(player, player.profit(type));
        }
        return new Profit(profits);
    }

    public double calculateProfitOfDealer() {
        return (-1) * profits.keySet().stream()
                .mapToDouble(profits::get)
                .sum();
    }

    public double findProfitByPlayer(Player player) {
        return profits.get(player);
    }
}
