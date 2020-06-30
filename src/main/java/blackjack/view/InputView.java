package blackjack.view;

import blackjack.domain.user.Player;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static String inputPlayers() {
        System.out.println("게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)");
        return scanner.nextLine();
    }

    public static int inputBettingMoney(Player player) {
        System.out.println(player.getName() + "의 배팅 금액은?");
        return Integer.parseInt(scanner.nextLine());
    }
}
