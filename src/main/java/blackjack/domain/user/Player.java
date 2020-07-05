package blackjack.domain.user;

import blackjack.domain.ResultType;
import blackjack.domain.user.bettingmoney.BettingMoney;

public class Player extends User {

    private BettingMoney bettingMoney;

    public Player(String name) {
        super(name);
    }

    public double profit(ResultType type) {
        return bettingMoney.calculateProfit(type);
    }

    public void setBettingMoney(int money) {
        this.bettingMoney = BettingMoney.from(money);
    }

    @Override
    public boolean canDraw() {
        return cards.score() < 21;
    }
}
