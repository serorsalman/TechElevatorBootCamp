package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class NonStartTest {
    @Test
    public void getPartialStringTest_send_in_HelloThere_returns_ellohere() {
        NonStart nonStart = new NonStart();

        String actual = nonStart.getPartialString("Hello", "There");
        String expected = "ellohere";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getPartialStringTest_send_in_javaCode_returns_avaOde() {
        NonStart nonStart = new NonStart();

        String actual = nonStart.getPartialString("java", "code");
        String expected = "avaode";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getPartialStringTest_send_in_shotlJava_returns_hotLava() {
        NonStart nonStart = new NonStart();

        String actual = nonStart.getPartialString("shotl", "java");
        String expected = "hotlava";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getPartialStringTest_send_in_serorSalman_returns_erorAlman() {
        NonStart nonStart = new NonStart();

        String actual = nonStart.getPartialString("Seror", "Salman");
        String expected = "eroralman";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getPartialStringTest_send_in_doorMop_returns_erorAlman() {
        NonStart nonStart = new NonStart();

        String actual = nonStart.getPartialString("Door", "Mop");
        String expected = "oorop";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getPartialStringTest_send_in_andOr_returns_ndr() {
        NonStart nonStart = new NonStart();

        String actual = nonStart.getPartialString("And", "Or");
        String expected = "ndr";
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void getPartialStringTest_send_in_aThere_returns_here() {
        NonStart nonStart = new NonStart();

        String actual = nonStart.getPartialString("a", "There");
        String expected = "here";
        Assert.assertEquals(expected, actual);
    }

}

