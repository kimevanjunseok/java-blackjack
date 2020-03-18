package model;

import java.util.List;

public class Dealer extends BlackJackGameUser {
    private static final int FIRST = 0;
    public static final String DEALER_NAME = "딜러";
    public static final int HIT_BOUNDARY = 16;

    public Dealer(Deck deck, int initialDrawCount) {
        super(DEALER_NAME, deck, initialDrawCount);
    }

    public Dealer(List<Card> cards) {
        super(DEALER_NAME, cards);
    }

    public String toStringCardHandFirst() {
        return cardHand.getCards().get(FIRST).toString();
    }

    public boolean isHitBound() {
        return getScore() <= HIT_BOUNDARY;
    }
}
