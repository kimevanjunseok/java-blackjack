package blackjack.domain.card;

public enum SuitType {
    SPADE("스페이드"),
    HEART("하트"),
    DIAMOND("다이아몬드"),
    CLUB("클로버");

    private final String name;

    SuitType(final String name) {
        this.name = name;
    }
}
