package model;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class PlayersData {
    private final Map<String, BettingMoney> playersData = new LinkedHashMap<>();

    public PlayersData(Map<String, BettingMoney> playersData) {
        this.playersData.putAll(playersData);
    }

    public BettingMoney getBettingMoney(String name){
        return playersData.get(name);
    }

    public Set<String> getNames(){
        return playersData.keySet();
    }
}
