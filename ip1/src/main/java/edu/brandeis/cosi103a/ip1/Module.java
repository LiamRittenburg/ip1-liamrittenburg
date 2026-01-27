package edu.brandeis.cosi103a.ip1;

public class Module extends AutomationCard {

    public Module()
    {
        this.cost = 5;
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
