package edu.brandeis.cosi103a.ip1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    ArrayList<Card> hand;
    ArrayList<Card> discardPile;
    ArrayList<Card> drawPile;
    ArrayList<Card> allCards;


    public Deck() {
        hand = new ArrayList<Card>();
        discardPile = new ArrayList<Card>();
        drawPile = new ArrayList<Card>();
        allCards = new ArrayList<Card>();
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public void shuffle(ArrayList<Card> cards) {
        Collections.shuffle(cards);
    }

    public void discardHand() {
        discardPile.addAll(hand);
        hand.clear();
    }

    public void refillHand() {
        while (hand.size() < 5) {
            if (drawPile.isEmpty()) {
                drawPile.addAll(discardPile);
                discardPile.clear();
                shuffle(drawPile);
            }
            if (!drawPile.isEmpty()) {
                hand.add(drawPile.remove(drawPile.size() - 1));
            } else {
                break; // No more cards to draw
            }
        }
    }

    public ArrayList<Card> getDiscard() {
        return discardPile;
    }

    public void addCardToAllCards(Card card) {
        allCards.add(card);
    }

    public void addCardToDrawPile(Card card) {
        drawPile.add(card);
    }

    public void addCardToDiscardPile(Card card) {
        discardPile.add(card);
    }

    public void addCardToHand(Card card) {
        hand.add(card);
    }



}
