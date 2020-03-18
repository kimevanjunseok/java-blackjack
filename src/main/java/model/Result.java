package model;

import exception.IllegalResultException;

import java.util.Arrays;

import static controller.BlackJackGame.*;

public enum Result {
    BLACKJACK(-2, BLACK_JACK_RATIO),
    WIN(-1, WIN_RATIO),
    LOSE(1, LOSE_RATIO),
    DRAW(0, DRAW_RATIO);

    int resultValue;
    double ratio;

    Result(int resultValue, double ratio) {
        this.resultValue = resultValue;
        this.ratio = ratio;
    }

    public double calculateRevenue(Player player) {
        return player.multiplyBettingMoney(ratio);
    }

    public static Result compete(Dealer dealer, Player player) {
        if (dealer.isBlackJack() && player.isBlackJack()) {
            return DRAW;
        }
        if (player.isBlackJack()) {
            return BLACKJACK;
        }
        if (dealer.isBlackJack()) {
            return LOSE;
        }
        if (dealer.isBust() && player.isBust()) {
            return LOSE;
        }
        if (dealer.isBust()) {
            return WIN;
        }
        if (player.isBust()) {
            return LOSE;
        }
        int compareValue = BlackJackGameUser.compare(dealer, player);
        return Arrays.stream(Result.values())
                .filter(result -> result.isSameResult(compareValue))
                .findFirst()
                .orElseThrow(() -> new IllegalResultException("올바른 비교 값이 아닙니다."));
    }

    private boolean isSameResult(int compareValue) {
        return this.resultValue == compareValue;
    }
}
