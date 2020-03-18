package controller;

import model.*;
import view.InputView;
import view.OutputView;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class BlackJackGame {
    private static final int ADDITIONAL_DRAW_COUNT = 1;
    public static final int INITIAL_DRAW_COUNT = 2;
    public static final String COMMA = ",";

    public static void play() {
        Deck deck = new Deck(CardFactory.createCardList());
        PlayerNames playerNames = new PlayerNames(InputView.inputPlayerNames());
        PlayersData playersData = new PlayersData(makePlayersData(playerNames));
        Players players = new Players(playersData, deck, INITIAL_DRAW_COUNT);
        Dealer dealer = new Dealer(deck, INITIAL_DRAW_COUNT);
        OutputView.printInitialCards(players, dealer);
        OutputView.printUsersCard(players, dealer);

        drawCardToPlayers(players, deck);
        hitOrStayForDealer(dealer, deck);
        OutputView.printFinalCardHandResult(players, dealer);

        GameResult gameResult = new GameResult(players, dealer);
        OutputView.printRevenue(gameResult);
    }

    private static Map<String, BettingMoney> makePlayersData(PlayerNames playerNames) {
        Map<String, BettingMoney> playerData = new LinkedHashMap<>();
        for (String name : playerNames) {
            playerData.put(name, new BettingMoney(InputView.inputBettingMoney(name)));
        }
        return Collections.unmodifiableMap(playerData);
    }

    private static void drawCardToPlayers(final Players players, final Deck deck) {
        for (Player player : players) {
            drawCardEachPlayer(deck, player);
        }
    }

    private static void drawCardEachPlayer(Deck deck, Player player) {
        while (!player.isOverBlackJack() && Answer.find(InputView.inputYesOrNo(player)).isYes()) {
            player.drawCard(deck, ADDITIONAL_DRAW_COUNT);
            OutputView.printPlayerCard(player);
        }
    }

    private static void hitOrStayForDealer(Dealer dealer, Deck deck) {
        if (dealer.isHitBound()) {
            OutputView.printDealerDraw(dealer);
            dealer.drawCard(deck, ADDITIONAL_DRAW_COUNT);
        }
    }
}
