package blackjack.controller;

import blackjack.domain.Answer;
import blackjack.domain.Profit;
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
        initDrawCard(dealer, players, deck);
        hit(dealer, players, deck);
        profit(dealer, players);
    }

    private Players initPlayers() {
        List<Player> players = PlayerFactory.create(InputView.inputPlayers());
        for (Player player : players) {
            player.setBettingMoney(InputView.inputBettingMoney(player));
        }
        return Players.from(players);
    }

    private void initDrawCard(Dealer dealer, Players players, Cards deck) {
        dealer.initDrawCard(deck);
        players.initDrawCard(deck);
        OutputView.printInitDrawCardNotice(dealer, players.getPlayers());
    }

    private void hit(Dealer dealer, Players players, Cards deck) {
        hitPlayers(players, deck);
        hitDealer(dealer, deck);
        OutputView.printResult(dealer, players.getPlayers());
    }

    private void hitPlayers(Players players, Cards deck) {
        for (Player player : players.getPlayers()) {
            hitPlayer(player, deck);
        }
    }

    private void hitPlayer(Player player, Cards deck) {
        if (player.canDraw()) {
            drawOrStay(player, deck);
        }
    }

    private void drawOrStay(Player player, Cards deck) {
        Answer answer;
        do {
            answer = Answer.find(InputView.inputAnswerOneMoreCard(player));
            answer.apply(player, deck);
            OutputView.printUserCard(player);
        } while (answer.isYes() && player.canDraw());
    }

    private void hitDealer(Dealer dealer, Cards deck) {
        if (dealer.canDraw()) {
            dealer.drawCard(deck);
            OutputView.printDealerGetCard();
        }
    }

    private void profit(Dealer dealer, Players players) {
        Profit profit = Profit.from(dealer, players.getPlayers());
        OutputView.printProfit(profit);
    }
}
