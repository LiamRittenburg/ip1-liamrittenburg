package edu.brandeis.cosi103a.ip1;

public class Framework extends AutomationCard {

    public Framework()
    {
        this.cost = 8;
        this.value = 6;
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
