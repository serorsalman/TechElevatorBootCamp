package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SameFirstLastTest {
    @Test
    public void isItTheSameTest_send_in_arrayNotEqual_returns_false() {
        SameFirstLast sameFirstLast = new SameFirstLast();
        int[] a = {1, 2, 3};
        boolean actual = sameFirstLast.isItTheSame(a);
        boolean expected = false;

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void isItTheSameTest_send_in_arrayEqual_returns_true() {
        SameFirstLast sameFirstLast = new SameFirstLast();
        int[] a = {3, 2, 3};
        boolean actual = sameFirstLast.isItTheSame(a);
        boolean expected = true;

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void isItTheSameTest_send_in_arrayEqualLong_returns_true() {
        SameFirstLast sameFirstLast = new SameFirstLast();
        int[] a = {6, 2, 4, 3, 6};
        boolean actual = sameFirstLast.isItTheSame(a);
        boolean expected = true;

        Assert.assertEquals(expected, actual);

    }


}