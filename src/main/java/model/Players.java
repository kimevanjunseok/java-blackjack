package model;

import java.util.*;

public class Players implements Iterable<Player> {
    private final List<Player> players = new ArrayList<>();

    public Players(PlayersData data, Deck deck, int initialDrawCount) {
        for (String name : data.getNames()) {
            players.add(new Player(name, data.getBettingMoney(name), deck, initialDrawCount));
        }
    }

    public Players(List<Player> players) {
        this.players.addAll(players);
    }

    public String getNames() {
        List<String> names = new ArrayList<>();

        for (Player player : players) {
            names.add(player.getName());
        }
        return String.join(",", names);
    }

    @Override
    public Iterator<Player> iterator() {
        return players.iterator();
    }
}
