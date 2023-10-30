package com.telran.org.homeworkfour;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Deal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of players: ");
        int numPlayers = scanner.nextInt();
        scanner.close();

        Deal game = new Deal();
        game.shuffleDeck();
        game.dealCards(numPlayers, 5);
    }

    private final Card[] deck;

    public Deal() {
        deck = new Card[Suits.values().length * Rank.values().length];
        int index = 0;
        for (Suits suit : Suits.values()) {
            for (Rank rank : Rank.values()) {
                deck[index] = new Card(suit, rank);
                index++;
            }
        }
    }

    public void shuffleDeck() {
        Card[] cardArray = new Card[deck.length];
        System.arraycopy(deck, 0, cardArray, 0, deck.length);

        Random rand = new Random();

        for (int i = deck.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);

            Card temp = cardArray[i];
            cardArray[i] = cardArray[j];
            cardArray[j] = temp;
        }

        System.arraycopy(cardArray, 0, deck, 0, deck.length);
    }

    public void dealCards(int numPlayers, int cardsPerPlayer) {
        Player[] players = new Player[numPlayers];
        for (int i = 1; i <= numPlayers; i++) {
            players[i - 1] = new Player("Player " + i, cardsPerPlayer);
        }

        int index = 0;
        for (int i = 0; i < cardsPerPlayer; i++) {
            for (Player player : players) {
                player.addCardToHand(deck[index]);
                index++;
            }
        }

        for (Player player : players) {
            System.out.println(player.getName() + ": " + Arrays.toString(player.getHand()));
        }
    }
}
