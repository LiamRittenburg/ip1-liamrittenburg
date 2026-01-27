package edu.brandeis.cosi103a.ip1;

import java.util.ArrayList;

public class Player {
    Deck deck;

    public Player() {
        deck = new Deck();
    }

    public int calculatePlayValue() {
        int totalValue = 0;
        for (Card card : deck.getHand()) {
            if (card instanceof CryptoCard) {
                totalValue += card.getValue();
            }
        }
        return totalValue;
    }

    public void cleanup() {
        deck.discardHand();
        deck.refillHand();
    }

    public int getAutomationValue() {
        int totalValue = 0;
        for (Card card : deck.getDiscard()) {
            if (card instanceof AutomationCard) {
                totalValue += card.getValue();
            }
        }
        return totalValue;
    }

    public void addStartingDeck(ArrayList<Card> startingCards) {
        for (Card card : startingCards) {
            deck.addCardToDrawPile(card);
            deck.addCardToAllCards(card);
        }
        deck.shuffle(deck.drawPile);
        deck.refillHand();
    }

    
}
