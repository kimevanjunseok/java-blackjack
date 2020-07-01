package blackjack.domain.user;

import blackjack.domain.card.Card;

import java.util.List;

public class Dealer extends User {

    private static final String DEALER_NAME = "딜러";

    public Dealer() {
        super(DEALER_NAME);
    }

    public Card getFirstCard() {
        List<Card> deck = cards.getCards();
        return deck.get(0);
    }
}
