package com.techelevator.farm;

import java.math.BigDecimal;

public class Apple implements Sellable{

    @Override
    public BigDecimal getPrice(){
        // provide the body for the overridden method getPrice()
        BigDecimal pricePerApple = new BigDecimal("0.20");
        return pricePerApple;
    }
}
