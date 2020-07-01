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

    public Card draw() {
        Collections.shuffle(cards);
        return cards.remove(0);
    }

    public List<Card> getCards() {
        return Collections.unmodifiableList(cards);
    }
}
