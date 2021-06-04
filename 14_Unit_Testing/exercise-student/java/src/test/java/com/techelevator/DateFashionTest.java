package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class DateFashionTest {
    @Test
    public void getATableTest_send_in_aboveStyle_returns_yes() {
        DateFashion dateFashion = new DateFashion();
        int actual = dateFashion.getATable(8, 9);
        int expected = 2;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getATableTest_send_in_lessStyle_returns_no() {
        DateFashion dateFashion = new DateFashion();
        int actual = dateFashion.getATable(2, 3);
        int expected = 0;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getATableTest_send_in_averageStyle_returns_maybe() {
        DateFashion dateFashion = new DateFashion();
        int actual = dateFashion.getATable(6, 3);
        int expected = 1;

        Assert.assertEquals(expected, actual);
    }


}