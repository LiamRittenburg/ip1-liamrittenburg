package edu.brandeis.cosi103a.ip1;

import java.util.ArrayList;

public class Supply {
    private final Deck supplyDeck;
    private int frameworkCount = 8;
    private int moduleCount = 8;
    private int methodCount = 14;
    private int bitcoinCount = 60;
    private int ethereumCount = 40;
    private int dogeCount = 30;

    public Supply() {
        supplyDeck = new Deck();
        
        // Add crypto cards
        for (int i = 0; i < 60; i++) {
            supplyDeck.addCardToAllCards(new Bitcoin());
        }
        for (int i = 0; i < 40; i++) {
            supplyDeck.addCardToAllCards(new Ethereum());
        }
        for (int i = 0; i < 30; i++) {
            supplyDeck.addCardToAllCards(new Doge());
        }
        
        // Add automation cards
        for (int i = 0; i < 14; i++) {
            supplyDeck.addCardToAllCards(new Method());
        }
        for (int i = 0; i < 8; i++) {
            supplyDeck.addCardToAllCards(new Module());
        }
        for (int i = 0; i < 8; i++) {
            supplyDeck.addCardToAllCards(new Framework());
        }
        supplyDeck.shuffle(supplyDeck.allCards);
    }

    public boolean drawBitcoin() {
        if (bitcoinCount > 0) {
            bitcoinCount--;
            return true;
        }
        return false;
    }

    public boolean drawEthereum() {
        if (ethereumCount > 0) {
            ethereumCount--;
            return true;
        }
        return false;
    }

    public boolean drawDoge() {
        if (dogeCount > 0) {
            dogeCount--;
            return true;
        }
        return false;
    }

    public boolean drawMethod() {
        if (methodCount > 0) {
            methodCount--;
            return true;
        }
        return false;
    }

    public boolean drawModule() {
        if (moduleCount > 0) {
            moduleCount--;
            return true;
        }
        return false;
    }

    public boolean drawFramework() {
        if (frameworkCount > 0) {
            frameworkCount--;
            return true;
        }
        return false;
    }

    public Card buyCard(int cost) {
        for (Card card : supplyDeck.allCards) {
            if (card.getCost() <= cost) {
                if (card instanceof Framework) {
                    drawFramework();
                } else if (card instanceof Module) {
                    drawModule();
                } else if (card instanceof Method) {
                    drawMethod();
                } else if (card instanceof Bitcoin) {
                    drawBitcoin();
                } else if (card instanceof Ethereum) {
                    drawEthereum();
                } else if (card instanceof Doge) {
                    drawDoge();
                }
                // Remove card from supply deck
                supplyDeck.allCards.remove(card);
                return card;
            }
        }
        return null; // No card could be afforded
        
    }

    public int getFrameworkCount() {
        return frameworkCount; // Total frameworks in supply
    }

    public boolean hasFrameworksRemaining() {
        // Check if any frameworks are still available in the supply
        return getFrameworkCount() > 0;
    }

    public ArrayList<Card> setupStartingDeck() {
        ArrayList<Card> startingDeck = new ArrayList<Card>();
        // Add 7 Bitcoins
        for (int i = 0; i < 7; i++) {
            startingDeck.add(new Bitcoin());
            drawBitcoin();
        }
        // Add 3 Methods
        for (int i = 0; i < 3; i++) {
            startingDeck.add(new Method());
            drawMethod();
        }
        return startingDeck;
    }
}
