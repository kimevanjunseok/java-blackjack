package blackjack.view;

import blackjack.domain.user.Dealer;
import blackjack.domain.user.Player;
import blackjack.domain.user.User;

import java.util.List;
import java.util.StringJoiner;

public class OutputView {

    public static void printInitDrawCardNotice(Dealer dealer, List<Player> players) {
        StringJoiner stringJoiner = new StringJoiner(", ");
        for (Player user : players) {
            stringJoiner.add(user.getName());
        }
        System.out.println("딜러와 " + stringJoiner.toString() + "에게 2장의 나누었습니다.");

        printUserCard(dealer);
        printPlayersCard(players);
    }

    private static void printPlayersCard(List<Player> players) {
        for (Player player : players) {
            printUserCard(player);
        }
    }

    public static void printUserCard(User user) {
        System.out.println(user.getName() + "카드: ");
    }
}
