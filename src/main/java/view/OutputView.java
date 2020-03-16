package view;

import model.*;

import java.util.Map;

import static controller.BlackJackGame.INITIAL_DRAW_COUNT;
import static controller.BlackJackGame.HIT_BOUNDARY;
import static model.Dealer.DEALER_NAME;

public class OutputView {
    public static final String DELIMITER = ": ";
    public static final String NEW_LINE = "\n";
    public static final String RESULT_STRING = " - 결과: ";

    public static void printInitialCards(Players players, Dealer dealer) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("\n")
                .append(dealer.getName())
                .append("와 ")
                .append(players.getNames())
                .append("에게 ")
                .append(INITIAL_DRAW_COUNT)
                .append("장의 카드를 나누었습니다.");
        System.out.println(stringBuilder.toString());
    }

    public static void printUsersCard(Players players, Dealer dealer) {
        printDealerCard(dealer);
        printPlayersCard(players);
    }

    private static void printDealerCard(Dealer dealer) {
        System.out.print(NEW_LINE + dealer.getName() + DELIMITER + dealer.toStringCardHandFirst());
    }

    private static void printPlayersCard(Players players) {
        for (Player player : players) {
            printPlayerCard(player);
        }
        System.out.println();
    }

    public static void printPlayerCard(User user) {
        System.out.print(NEW_LINE + user.getName() + DELIMITER + user.toStringCardHand());
    }

    public static void printDealerDraw(Dealer dealer) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(NEW_LINE)
                .append(dealer.getName())
                .append("는 ")
                .append(HIT_BOUNDARY)
                .append("이하라 한장의 카드를 더 받았습니다.");
        System.out.println(stringBuilder.toString());
    }

    public static void printFinalCardHandResult(final Players players, final Dealer dealer) {
        System.out.println();
        printPlayerCard(dealer);
        System.out.print(RESULT_STRING + dealer.getScore());
        for (Player player : players) {
            printPlayerCard(player);
            System.out.print(RESULT_STRING + player.getScore());
        }
    }

    public static void printResult(final GameResult gameResult) {
        System.out.println(NEW_LINE + NEW_LINE + "## 최종 승패");
        printDealerResult(gameResult.getDealerResult());
        printPlayersResult(gameResult.getPlayerResult());
    }

    public static void printDealerResult(final Map<Result, Integer> result) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(DEALER_NAME)
                .append(DELIMITER)
                .append(result.get(Result.WIN))
                .append("승 ")
                .append(result.get(Result.LOSE))
                .append("패");
        System.out.println(stringBuilder.toString());
    }

    private static void printPlayersResult(final Map<Player, Result> result) {
        for (Player player : result.keySet()) {
            System.out.print(player.getName() + DELIMITER);
            System.out.println(result.get(player).toString());
        }
    }
}
