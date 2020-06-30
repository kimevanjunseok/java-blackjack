package blackjack.domain.user;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PlayerFactory {

    public static List<Player> create(String inputPlayers) {
        List<Player> players = new ArrayList<>();

        List<String> playerNames = Arrays.asList(inputPlayers.split(","));
        for (String playerName : playerNames) {
            players.add(new Player(playerName));
        }

        return Collections.unmodifiableList(players);
    }
}
