package com.telran.org.homeworkfour;

public class Player {
    private final String name;
    private final Card[] hand;
    private int cardsInHand;

    public Player(String name, int handSize) {
        this.name = name;
        this.hand = new Card[handSize];
        this.cardsInHand = 0;
    }

    public String getName() {
        return name;
    }

    public void addCardToHand(Card card) {
        if (cardsInHand < hand.length) {
            hand[cardsInHand] = card;
            cardsInHand++;
        }
    }

    public Card[] getHand() {
        return hand;
    }
}
