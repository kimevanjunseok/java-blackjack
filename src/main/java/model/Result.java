package model;

import exception.IllegalResultException;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Result {
    BLACKJACK("블랙잭", -2, (dealer, player) -> {
        if (dealer.isBlackJack()) {
            return 0.0;
        }
        return player.getBettingMoney() * 1.5;
    }),
    WIN("승", -1, (dealer, player) -> player.getBettingMoney()),
    LOSE("패", 1, (dealer, player) -> player.getBettingMoney() * -1),
    DRAW("무", 0, (dealer, player) -> 0.0);

    String result;
    int resultValue;
    BiFunction<Dealer, Player, Double> operate;

    Result(String result, int resultValue, BiFunction<Dealer, Player, Double> operate) {
        this.result = result;
        this.resultValue = resultValue;
        this.operate = operate;
    }

    @Override
    public String toString() {
        return result;
    }

    public double calculateRevenue(Dealer dealer, Player player){
        return operate.apply(dealer, player);
    }

    public static Result compete(Dealer dealer, Player player) {
        if (player.isBlackJack()) {
            return BLACKJACK;
        }
        if (dealer.isBust() && player.isBust()) {
            return DRAW;
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

    public static Result oppositeResult(Result result) {
        if (isWin(result)) {
            return LOSE;
        }
        if (isLose(result)) {
            return WIN;
        }
        return DRAW;
    }

    private static boolean isLose(final Result result) {
        return result == LOSE;
    }

    private static boolean isWin(final Result result) {
        return result == WIN;
    }


}
