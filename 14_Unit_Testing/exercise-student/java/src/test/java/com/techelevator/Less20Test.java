package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class Less20Test {
    @Test
    public void isLessThanMultipleOf20Test_send_in_oneLessN_returns_true() {
        Less20 less20 = new Less20();
        boolean actual = less20.isLessThanMultipleOf20(39);

        Assert.assertTrue(actual);
    }

    @Test
    public void isLessThanMultipleOf20Test_send_in_towLessN_returns_true() {
        Less20 less20 = new Less20();
        boolean actual = less20.isLessThanMultipleOf20(40);

        Assert.assertFalse(actual);
    }

    @Test
    public void isLessThanMultipleOf20Test_send_in_towLess_returns_true() {
        Less20 less20 = new Less20();
        boolean actual = less20.isLessThanMultipleOf20(20);

        Assert.assertFalse(actual);
    }

    @Test
    public void isLessThanMultipleOf20Test_send_in_oneLess_returns_true() {
        Less20 less20 = new Less20();
        boolean actual = less20.isLessThanMultipleOf20(19);

        Assert.assertTrue(actual);


    }
}