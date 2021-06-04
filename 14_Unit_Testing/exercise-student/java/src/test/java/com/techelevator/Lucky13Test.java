package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class Lucky13Test {
    @Test
    public void getLuckyTest_send_in_noOdds_returns_true() {
        Lucky13 lucky13 = new Lucky13();
        int[] a = {0, 2, 4};

        boolean actual = lucky13.getLucky(a);
        boolean expected = true;
        Assert.assertEquals(expected, actual);


    }

    @Test
    public void getLuckyTest_send_in_Odds_returns_false() {
        Lucky13 lucky13 = new Lucky13();
        int[] a = {1, 2, 3};

        boolean actual = lucky13.getLucky(a);
        boolean expected = false;
        Assert.assertEquals(expected, actual);


    }

    @Test
    public void getLuckyTest_send_in_oneOdds_returns_false() {
        Lucky13 lucky13 = new Lucky13();
        int[] a = {1, 2, 5};

        boolean actual = lucky13.getLucky(a);
        boolean expected = false;
        Assert.assertEquals(expected, actual);


    }

}