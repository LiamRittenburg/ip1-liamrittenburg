package edu.brandeis.cosi103a.ip1;

public class Method extends AutomationCard {

    public Method()
    {
        this.cost = 2;
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
