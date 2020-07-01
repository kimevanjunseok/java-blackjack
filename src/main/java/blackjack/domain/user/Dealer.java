package blackjack.domain.user;

import blackjack.domain.card.Card;

public class Dealer extends User {

    private static final String DEALER_NAME = "딜러";

    public Dealer() {
        super(DEALER_NAME);
    }

    public Card getFirstCard() {
        return cards.getFirstCards();
    }

    @Override
    public boolean canDraw() {
        return cards.score() <= 16;
    }
}
