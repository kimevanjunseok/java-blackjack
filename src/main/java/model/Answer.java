package model;

import exception.IllegalYesOrNoInputException;
import utils.StringUtils;

import java.util.Arrays;

public enum Answer {
    YES("y", true),
    NO("n", false);

    private String answer;
    private boolean isYes;

    Answer(String answer, boolean isYes) {
        this.answer = answer;
        this.isYes = isYes;
    }

    public static Answer getYesOrNoByValue(String input) {
        validate(input);
        return Arrays.stream(Answer.values())
                .filter(answer -> answer.isSameYesOrNo(input))
                .findAny()
                .orElseThrow(() -> new IllegalYesOrNoInputException(String.format("%s는 올바르지 않은 값입니다.", input)));
    }

    private boolean isSameYesOrNo(final String input) {
        return answer.equalsIgnoreCase(input);
    }

    private static void validate(String input) {
        StringUtils.validateNull(input);
        StringUtils.validateEmpty(input);
    }

    public boolean isYes() {
        return isYes;
    }
}

