package blackjack.domain.card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cards {

    private List<Card> cards;

    private Cards(List<Card> cards) {
        this.cards = new ArrayList<>(cards);
    }

    public static Cards from(List<Card> cards) {
        return new Cards(cards);
    }

    public void add(Card card) {
        cards.add(card);
    }

    public Card getFirstCards() {
        if (cards.size() < 1) {
            throw new IllegalArgumentException("카드 없는데?");
        }
        return cards.get(0);
    }

    public Card draw() {
        Collections.shuffle(cards);
        return cards.remove(0);
    }

    public int score() {
        if (hasAce()) {
            return scoreWithAce();
        }
        return scoreWithoutAce();
    }

    private int scoreWithAce() {
        int score = scoreWithoutAce();
        if (score + 10 > 21) {
            return score;
        }
        return score + 10;
    }

    private int scoreWithoutAce() {
        return cards.stream()
                .mapToInt(Card::score)
                .sum();
    }

    private boolean hasAce() {
        return cards.stream()
                .anyMatch(Card::isAce);
    }

    public List<Card> getCards() {
        return Collections.unmodifiableList(cards);
    }
}
