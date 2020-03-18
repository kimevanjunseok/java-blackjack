package model;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class GameResult {
    private final Players players;
    private final Dealer dealer;
    private final Map<Player, Revenue> playersResult = new LinkedHashMap<>();

    public GameResult(final Players players, final Dealer dealer) {
        this.players = players;
        this.dealer = dealer;
        makePlayersResult();
    }

    private void makePlayersResult() {
        for (Player player : players) {
            Result result = Result.compete(dealer, player);
            playersResult.put(player, new Revenue(result.calculateRevenue(player)));
        }
    }

    public Map<Player, Revenue> getPlayersResult() {
        return Collections.unmodifiableMap(playersResult);
    }

    public Revenue getDealerResult() {
        return new Revenue(playersResult.values().stream()
                .mapToDouble(Revenue::getRevenue)
                .sum() * -1.0);
    }
}
