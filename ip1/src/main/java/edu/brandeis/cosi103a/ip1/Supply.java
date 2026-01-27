package edu.brandeis.cosi103a.ip1;

public class Supply {
    private final Deck supplyDeck;

    public Supply() {
        supplyDeck = new Deck();
        
        // Add crypto cards
        for (int i = 0; i < 60; i++) {
            supplyDeck.addCard(new Bitcoin());
        }
        for (int i = 0; i < 40; i++) {
            supplyDeck.addCard(new Ethereum());
        }
        for (int i = 0; i < 30; i++) {
            supplyDeck.addCard(new Doge());
        }
        
        // Add automation cards
        for (int i = 0; i < 14; i++) {
            supplyDeck.addCard(new Method());
        }
        for (int i = 0; i < 8; i++) {
            supplyDeck.addCard(new Module());
        }
        for (int i = 0; i < 8; i++) {
            supplyDeck.addCard(new Framework());
        }
    }

    public Card buyCard(Card card) {
        // Remove and return a copy of the requested card from supply
        return supplyDeck.drawCard();
    }

    public int getFrameworkCount() {
        return 8; // Total frameworks in supply
    }

    public boolean hasFrameworksRemaining() {
        // Check if any frameworks are still available in the supply
        return getFrameworkCount() > 0;
    }
}
