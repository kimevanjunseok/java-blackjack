package blackjack.view;

import blackjack.domain.Profit;
import blackjack.domain.card.Card;
import blackjack.domain.card.Cards;
import blackjack.domain.user.Dealer;
import blackjack.domain.user.Player;
import blackjack.domain.user.User;

import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

public class OutputView {

    public static void printInitDrawCardNotice(Dealer dealer, List<Player> players) {
        StringJoiner stringJoiner = new StringJoiner(", ");
        for (Player user : players) {
            stringJoiner.add(user.getName());
        }
        System.out.println("딜러와 " + stringJoiner.toString() + "에게 2장의 나누었습니다.");

        printDealerCard(dealer);
        printPlayersCard(players);
    }

    private static void printDealerCard(Dealer dealer) {
        System.out.println(dealer.getName() + "카드: " + dealer.getFirstCard());
    }

    private static void printPlayersCard(List<Player> players) {
        for (Player player : players) {
            printUserCard(player);
        }
    }

    public static void printUserCard(User user) {
        StringJoiner stringJoiner = toCardsString(user);
        System.out.println(user.getName() + "카드: " + stringJoiner.toString());
    }

    public static void printDealerGetCard() {
        System.out.println("딜러는 16이하라 한장의 카드를 더 받았습니다.");
    }

    public static void printResult(Dealer dealer, List<Player> players) {
        printDealerResult(dealer);
        printDealerPlayers(players);
    }

    private static void printDealerResult(Dealer dealer) {
        System.out.println(dealer.getName() + "카드: " + toCardsString(dealer).toString() + " - 결과: " + dealer.score());
    }

    private static void printDealerPlayers(List<Player> players) {
        for (Player player : players) {
            System.out.println(player.getName() + "카드: " + toCardsString(player).toString() + " - 결과: " + player.score());
        }
    }

    public static void printProfit(Profit profits) {
        System.out.println("## 최종 수익");
        System.out.println("딜러: " + profits.calculateProfitOfDealer());
        for (Player player : profits.keySet()) {
            System.out.println(player.getName() + ": " + profits.findProfitByPlayer(player));
        }

    }

    private static StringJoiner toCardsString(User user) {
        StringJoiner stringJoiner = new StringJoiner(", ");
        Cards userDeck = user.getCards();
        for (Card card : userDeck.getCards()) {
            stringJoiner.add(card.toString());
        }
        return stringJoiner;
    }
}
