package blackjack.domain.user.bettingmoney;

import blackjack.domain.ResultType;

public class BettingMoney {

    private static final int MINIMUM_BETTING_MONEY = 1;

    private final int money;

    private BettingMoney(int money) {
        validateNegative(money);
        this.money = money;
    }

    public static BettingMoney from(int money) {
        return new BettingMoney(money);
    }

    private void validateNegative(int money) {
        if (money < MINIMUM_BETTING_MONEY) {
            throw new IllegalArgumentException("최소 배팅 금액은 $1입니다. Betting Money: " + money);
        }
    }

    public double calculateProfit(ResultType type) {
        return money * type.getEarningRate();
    }
}
