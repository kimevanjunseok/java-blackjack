package blackjack.domain.user;

import blackjack.domain.card.Cards;

import java.util.Collections;

public class User {

    private final String name;
    protected final Cards cards;

    public User(String name) {
        this.name = name;
        this.cards = Cards.from(Collections.emptyList());
    }

    public void drawCard(Cards deck) {
        cards.add(deck.draw());
    }

    public String getName() {
        return name;
    }

    public Cards getCards() {
        return cards;
    }
}
