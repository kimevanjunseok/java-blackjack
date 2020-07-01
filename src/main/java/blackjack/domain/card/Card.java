package blackjack.domain.card;

public class Card {

    private final DenominationType denominationType;
    private final SuitType suitType;

    private Card(final DenominationType denominationType, final SuitType suitType) {
        this.denominationType = denominationType;
        this.suitType = suitType;
    }

    public static Card of(final DenominationType denominationType, final SuitType suitType) {
        return new Card(denominationType, suitType);
    }

    @Override
    public String toString() {
        return denominationType.getSymbol() + suitType.getName();
    }
}
