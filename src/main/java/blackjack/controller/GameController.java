package blackjack.controller;

import blackjack.domain.card.CardFactory;
import blackjack.domain.card.Cards;
import blackjack.domain.user.Dealer;
import blackjack.domain.user.Player;
import blackjack.domain.user.PlayerFactory;
import blackjack.domain.user.Players;
import blackjack.view.InputView;
import blackjack.view.OutputView;

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
        Dealer dealer = new Dealer();
        Players players = initPlayers();
        Cards deck = Cards.from(CardFactory.create());
        initCard(dealer, players, deck);
        OutputView.printInitDrawCardNotice(dealer, players.getPlayers());
        for (Player player : players.getPlayers()) {
            InputView.inputAnswerOneMoreCard(player);
        }
    }

    private Players initPlayers() {
        List<Player> players = PlayerFactory.create(InputView.inputPlayers());
        for (Player player : players) {
            player.setBettingMoney(InputView.inputBettingMoney(player));
        }
        return Players.from(players);
    }

    private void initCard(Dealer dealer, Players players, Cards deck) {
        for (int i = 0; i < 2; i ++) {
            dealer.drawCard(deck);
            players.drawCard(deck);
        }
    }
}
