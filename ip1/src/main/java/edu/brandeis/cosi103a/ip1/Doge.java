package edu.brandeis.cosi103a.ip1;

public class Doge extends CryptoCard {
    
    public Doge() {
        this.cost = 6;
        this.value = 3;
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
