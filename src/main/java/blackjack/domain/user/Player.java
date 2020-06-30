package blackjack.domain.user;

import blackjack.domain.user.bettingmoney.BettingMoney;

public class Player extends User {

    private BettingMoney bettingMoney;

    public Player(String name) {
        super(name);
    }

    public void setBettingMoney(int money) {
        this.bettingMoney = BettingMoney.from(money);
    }
}
