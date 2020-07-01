package blackjack.domain.user;

import blackjack.domain.card.Cards;

import java.util.Collections;

public abstract class User {

    private final String name;
    protected final Cards cards;

    public User(String name) {
        this.name = name;
        this.cards = Cards.from(Collections.emptyList());
    }

    public void initDrawCard(Cards deck) {
        for (int count = 0; count < 2; count++) {
            cards.add(deck.draw());
        }
    }

    public void drawCard(Cards deck) {
        cards.add(deck.draw());
    }

    public int score() {
        return cards.score();
    }

    public abstract boolean canDraw();

    public String getName() {
        return name;
    }

    public Cards getCards() {
        return cards;
    }
}
