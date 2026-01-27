package edu.brandeis.cosi103a.ip1;

public class Ethereum extends CryptoCard {
    
    public Ethereum() {
        this.cost = 3;
        this.value = 2;
    }   

    @Override
    public int getValue() {
        return this.value;
    }

    @Override
    public int getCost() {
        return this.cost;
    }
}
