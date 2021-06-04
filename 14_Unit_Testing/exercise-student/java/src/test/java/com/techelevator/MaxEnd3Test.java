package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MaxEnd3Test {
    @Test
    public void makeArrayTest_send_in_maxNumber_returns_setNumbers() {
        MaxEnd3 maxEnd3 = new MaxEnd3();
        int[] a = {2, 11, 3};

        int[] actual = maxEnd3.makeArray(a);
        int[] expected = {3, 3, 3};

        Assert.assertArrayEquals(expected, actual);

    }

    @Test
    public void makeArrayTest_send_in_maxTwo_returns_setNumbers() {
        MaxEnd3 maxEnd3 = new MaxEnd3();
        int[] a = {9, 5, 2};

        int[] actual = maxEnd3.makeArray(a);
        int[] expected = {9, 9, 9};

        Assert.assertArrayEquals(expected, actual);

    }

    @Test
    public void makeArrayTest_send_in_maxSame_returns_setNumbers() {
        MaxEnd3 maxEnd3 = new MaxEnd3();
        int[] a = {6, 6, 6};

        int[] actual = maxEnd3.makeArray(a);
        int[] expected = {6, 6, 6};

        Assert.assertArrayEquals(expected, actual);


    }
}