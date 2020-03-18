package model;

import java.util.List;


public class BlackJackGameUser implements Comparable<BlackJackGameUser>{
    protected final String name;
    protected final CardHand cardHand;

    public BlackJackGameUser(String name, Deck deck, int initialDrawCount) {
        this.name = name;
        this.cardHand = deck.draw(initialDrawCount);
    }

    public BlackJackGameUser(String name, List<Card> cards) {
        this.name = name;
        this.cardHand = new CardHand();
        for (Card card : cards) {
            cardHand.addCard(card);
        }
    }

    public void drawCard(Deck deck, int drawCount) {
        for (Card drawCard : deck.draw(drawCount)) {
            this.cardHand.addCard(drawCard);
        }
    }

    public boolean isBust() {
        return cardHand.isBust();
    }

    public boolean isBlackJack() {
        return cardHand.isBlackJack();
    }

    public boolean isOverBlackJack() {
        return cardHand.isMoreThanBlackJack();
    }

    public String toStringCardHand(){
        return cardHand.toString();
    }

    public int getScore() {
        return cardHand.calculateScore();
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(BlackJackGameUser o) {
        Integer score = getScore();
        return score.compareTo(o.getScore());
    }
}
