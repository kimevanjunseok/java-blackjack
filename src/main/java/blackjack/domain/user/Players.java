package blackjack.domain.user;

import blackjack.domain.card.Cards;

import java.util.Collections;
import java.util.List;

public class Players {

    private final List<Player> players;

    private Players(List<Player> players) {
        this.players = players;
    }

    public static Players from(List<Player> players) {
        return new Players(players);
    }

    public void initDrawCard(Cards deck) {
        for (Player player : players) {
            player.initDrawCard(deck);
        }
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }
}
