package model;


import java.util.List;

public class Player extends BlackJackGameUser {
    private final BettingMoney bettingMoney;

    public Player(String name, BettingMoney bettingMoney, Deck deck, int initialDrawCount) {
        super(name, deck, initialDrawCount);
        this.bettingMoney = bettingMoney;
    }

    public Player(String name, List<Card> cards) {
        super(name, cards);
        this.bettingMoney = new BettingMoney("100");
    }

    public double multiplyBettingMoney(double factor) {
        return bettingMoney.multiplyBettingMoney(factor);
    }
}
