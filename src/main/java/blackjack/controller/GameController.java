package blackjack.controller;

public class GameController {

    private GameController() {}

    private static class InstanceGameController {
        private static final GameController INSTANCE = new GameController();
    }

    public static GameController getInstance() {
        return InstanceGameController.INSTANCE;
    }

    public void game() {

    }
}
