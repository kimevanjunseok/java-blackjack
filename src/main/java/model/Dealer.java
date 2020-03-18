package model;

import java.util.List;

import static controller.BlackJackGame.HIT_BOUNDARY;

public class Dealer extends BlackJackGameUser {
    public static final int ZERO = 0;
    public static final String DEALER_NAME = "딜러";

    public Dealer(Deck deck, int initialDrawCount) {
        super(DEALER_NAME, deck, initialDrawCount);
    }

    public Dealer(List<Card> cards){
        super(DEALER_NAME, cards);
    }

    public String toStringCardHandFirst() {
        return cardHand.getCards().get(ZERO).toString();
    }

    public boolean isHitBound() {
        return getScore() <= HIT_BOUNDARY;
    }
}
