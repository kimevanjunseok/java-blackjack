package blackjack.domain.user;

import blackjack.domain.ResultType;
import blackjack.domain.card.Cards;
import blackjack.domain.state.State;

import java.util.Collections;

public abstract class User {

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
        if (cards.score() == 21) {
            state = State.BLACKJACK;
        }
    }

    public void drawCard(Cards deck) {
        cards.add(deck.draw());
        if (cards.score() > 21) {
            state = State.BUST;
        }
    }

    public int score() {
        return cards.score();
    }

    public void stay() {
        state = State.STAY;
    }

    public abstract boolean canDraw();

    public String getName() {
        return name;
    }

    public Cards getCards() {
        return cards;
    }

    public boolean isBlackjack() {
        return state == State.BLACKJACK;
    }

    public boolean isBust() {
        return state == State.BUST;
    }

    public int compareScore(User user) {
        return Integer.compare(score(), user.score());
    }
}
