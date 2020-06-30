package blackjack.domain.card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardFactory {

    public static List<Card> create() {
        List<Card> cards = new ArrayList<>();
        for (DenominationType denominationType : DenominationType.values()) {
            for (SuitType suitType : SuitType.values()) {
                cards.add(Card.of(denominationType, suitType));
            }
        }
        return Collections.unmodifiableList(cards);
    }
}
