package edu.brandeis.cosi103a.ip1;

public class Bitcoin extends CryptoCard {
    
    public Bitcoin() {
        this.cost = 0;
        this.value = 1;
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
