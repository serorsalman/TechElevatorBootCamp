package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class FrontTimesTest {
    @Test
    public void generateStringTest_send_in_Chocolate_returns_firstTwo() {
        FrontTimes frontTimes = new FrontTimes();
        String actual = frontTimes.generateString("Chocolate", 2);
        String expected = "ChoCho";
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void generateStringTest_send_in_Chocolate_returns_firstThree() {
        FrontTimes frontTimes = new FrontTimes();
        String actual = frontTimes.generateString("Chocolate", 3);
        String expected = "ChoChoCho";
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void generateStringTest_send_in_Abc_returns_firstThree() {
        FrontTimes frontTimes = new FrontTimes();
        String actual = frontTimes.generateString("Abc", 3);
        String expected = "AbcAbcAbc";
        Assert.assertEquals(expected, actual);

    }

}