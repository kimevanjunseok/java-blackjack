package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import static controller.BlackJackGame.BLACK_JACK_COUNT;

public class CardHand implements Iterable<Card> {
    public static final int ADDITIONAL_ACE_SCORE = 10;

    private List<Card> cards = new ArrayList<>();

    public void addCard(Card card) {
        cards.add(card);
    }

    public int calculateScore() {
        if (isAce()) {
            return calculateScoreWithAce();
        }
        return calculateScoreWithNoAce();
    }

    public int calculateScoreWithAce() {
        int score = calculateScoreWithNoAce();
        if (score + ADDITIONAL_ACE_SCORE > BLACK_JACK_COUNT) {
            return score;
        }
        return score + ADDITIONAL_ACE_SCORE;
    }

    public int calculateScoreWithNoAce() {
        return cards.stream()
                .mapToInt(Card::calculateScore)
                .sum();
    }

    public boolean isAce() {
        return cards.stream().anyMatch(Card::isAce);
    }

    public List<Card> getCards() {
        return Collections.unmodifiableList(cards);
    }

    @Override
    public Iterator<Card> iterator() {
        return cards.iterator();
    }

    public boolean isBlackJack() {
        return calculateScore() == BLACK_JACK_COUNT;
    }

    public boolean isBust() {
        return calculateScore() > BLACK_JACK_COUNT;
    }

    public boolean isMoreThanBlackJack() {
        return calculateScore() >= BLACK_JACK_COUNT;
    }
}
