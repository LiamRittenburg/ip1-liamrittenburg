package edu.brandeis.cosi103a.ip1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    ArrayList<Card> hand;
    ArrayList<Card> discardPile;
    ArrayList<Card> drawPile;


    public Deck() {
        drawPile = new ArrayList<Card>();
        for (int i = 0; i < 7; i++){
            drawPile.add(new Bitcoin());
        }
        for (int i = 0; i < 3; i++){
            drawPile.add(new Method());
        }
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


}
