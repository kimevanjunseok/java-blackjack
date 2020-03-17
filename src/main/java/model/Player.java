package model;

public class Player extends BlackJackGameUser {
    private final BettingMoney bettingMoney;

    public Player(String name, BettingMoney bettingMoney, Deck deck, int initialDrawCount) {
        super(name, deck, initialDrawCount);
        this.bettingMoney = bettingMoney;
    }

    public double getBettingMoney() {
        return bettingMoney.getBettingMoney();
    }
}
