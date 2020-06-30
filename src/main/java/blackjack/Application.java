package blackjack;

import blackjack.controller.GameController;

public class Application {
    public static void main(String[] args) {
        GameController gameController  = GameController.getInstance();
        try {
            gameController.game();
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }
}
