package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringBitsTest {
    @Test
    public void getBitsTest_send_in_Hello_returns_Hlo() {

        StringBits stringBits = new StringBits();

        String actual = stringBits.getBits("Hello");
        String expected = "Hlo";

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getBitsTest_send_in_Hi_returns_H() {

        StringBits stringBits = new StringBits();

        String actual = stringBits.getBits("Hi");
        String expected = "H";

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getBitsTest_send_in_seror_returns_srr() {

        StringBits stringBits = new StringBits();

        String actual = stringBits.getBits("Seror");
        String expected = "Srr";

        Assert.assertEquals(expected, actual);
    }


}