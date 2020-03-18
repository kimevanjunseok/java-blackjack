package model;

import exception.PlayerNamesOverlapException;
import utils.StringUtils;

import java.util.*;

import static controller.BlackJackGame.COMMA;

public class PlayerNames implements Iterable<String> {
    private final List<String> names;

    public PlayerNames(String input) {
        validate(input);
        names = Arrays.asList(StringUtils.trimString(input).split(COMMA));
    }

    private void validate(String input) {
        StringUtils.validateNull(input);
        validateSplit(input);
        validateOverlap(input);
    }

    private void validateOverlap(String input) {
        String[] names = input.split(COMMA);
        if (names.length != Arrays.stream(names).distinct().count()) {
            throw new PlayerNamesOverlapException("사용자 이름은 중복될 수 없습니다.");
        }
    }

    private void validateSplit(String input) {
        String[] names = input.split(COMMA);
        for (String name : names) {
            StringUtils.validateEmpty(name);
        }
    }

    public boolean contains(String name) {
        return names.contains(name);
    }

    @Override
    public Iterator<String> iterator() {
        return names.iterator();
    }
}
