package edu.brandeis.cosi103a.ip1;

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

    public void buyCard(Card card) {
        deck.addToDiscard(card);
    }
}
