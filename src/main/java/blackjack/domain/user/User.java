package blackjack.domain.user;

import blackjack.domain.card.Cards;
import blackjack.domain.state.State;

import java.util.Collections;

public class User {

    private final String name;
    private State state;
    protected final Cards cards;

    public User(String name) {
        this.name = name;
        this.state = State.HIT;
        this.cards = Cards.from(Collections.emptyList());
    }

    public void initDrawCard(Cards deck) {
        for (int count = 0; count < 2; count++) {
            cards.add(deck.draw());
        }
    }

    public void drawCard(Cards deck) {
        if (state == State.HIT) {
            cards.add(deck.draw());
        }
    }

    public String getName() {
        return name;
    }

    public Cards getCards() {
        return cards;
    }
}
