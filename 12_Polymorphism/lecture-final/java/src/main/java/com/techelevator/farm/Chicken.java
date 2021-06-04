package com.techelevator.farm;

import java.math.BigDecimal;

public class Chicken extends FarmAnimal implements Sellable {

    public Chicken() {
        super("Chicken", "Cluck");
    }

    @Override
    public BigDecimal getPrice() {
        return new BigDecimal("12.00");
    }
}
