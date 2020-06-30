package blackjack.controller;

import blackjack.domain.user.Dealer;
import blackjack.domain.user.Player;
import blackjack.domain.user.PlayerFactory;
import blackjack.domain.user.Players;
import blackjack.view.InputView;

import java.util.List;

public class GameController {

    private GameController() {}

    private static class InstanceGameController {
        private static final GameController INSTANCE = new GameController();
    }

    public static GameController getInstance() {
        return InstanceGameController.INSTANCE;
    }

    public void game() {
        Players players = initPlayers();
        Dealer dealer = new Dealer();
    }

    private Players initPlayers() {
        List<Player> players = PlayerFactory.create(InputView.inputPlayers());
        for (Player player : players) {
            player.setBettingMoney(InputView.inputBettingMoney(player));
        }
        return Players.from(players);
    }
}
