package model;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class GameResult {

    private Players players;
    private Dealer dealer;
    private Map<Player, Revenue> playerResult = new LinkedHashMap<>();

    public GameResult(final Players players, final Dealer dealer) {
        this.players = players;
        this.dealer = dealer;
        calculateResults();
    }

    private void calculateResults() {
        for (Player player : players) {
            Result result = Result.compete(dealer, player);
            playerResult.put(player, new Revenue(result.calculateRevenue(dealer, player)));
        }
    }

    public Map<Player, Revenue> getPlayerResult() {
        return Collections.unmodifiableMap(playerResult);
    }

    public Revenue getDealerResult() {
        return new Revenue(playerResult.values().stream()
                .mapToDouble(Revenue::getRevenue)
                .sum() * -1);
    }
}
