package blackjack.domain;

import java.util.Arrays;

public enum Answer {
    YES("Y"),
    NO("N");

    private final String answer;

    Answer(String answer) {
        this.answer = answer;
    }

    public static Answer find(String answer) {
        return Arrays.stream(Answer.values())
                .filter(type -> type.answer.equalsIgnoreCase(answer))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("대답 좀 똑바로 해라."));
    }
}
