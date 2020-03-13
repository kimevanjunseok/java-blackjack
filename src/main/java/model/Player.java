package model;

import java.util.Objects;

public class Player extends BlackJackPerson {
    private Result result;

    public Player(String name, CardHand cardHand) {
        super(name, cardHand);
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public Result getResult() {
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Player player = (Player) o;
        return result == player.result;
    }

    @Override
    public int hashCode() {
        return Objects.hash(result);
    }
}
