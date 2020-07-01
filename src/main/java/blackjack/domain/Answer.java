package blackjack.domain;

import blackjack.domain.card.Cards;
import blackjack.domain.user.Player;
import blackjack.domain.user.User;

import java.util.Arrays;
import java.util.function.BiConsumer;

public enum Answer {
    YES("Y", User::drawCard),
    NO("N", (player, deck) -> player.stay());

    private final String answer;
    private final BiConsumer<Player, Cards> behavior;

    Answer(String answer, BiConsumer<Player, Cards> behavior) {
        this.answer = answer;
        this.behavior = behavior;
    }

    public void apply(Player player, Cards deck) {
        behavior.accept(player, deck);
    }

    public static Answer find(String answer) {
        return Arrays.stream(Answer.values())
                .filter(type -> type.answer.equalsIgnoreCase(answer))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("대답 좀 똑바로 해라."));
    }

    public boolean isYes() {
        return this == Answer.YES;
    }
}
