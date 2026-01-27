package edu.brandeis.cosi103a.ip1;


public abstract class CryptoCard extends Card{
    int cost;
    int value;

    public abstract int getValue();
    public abstract int getCost();
}
