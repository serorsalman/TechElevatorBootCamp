package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CigarPartyTest {
    @Test
    public void havePartyTest_send_in_minCigar_return_notWeekend() {
        //Arrange
        CigarParty cigarParty = new CigarParty();
        //Act
        boolean actual = cigarParty.haveParty(30, false);
        boolean expected = false;

        Assert.assertEquals(false, actual);
    }

    @Test
    public void havePartyTest_send_in_maxCigar_return_notWeekend() {
        //Arrange
        CigarParty cigarParty = new CigarParty();
        //Act
        boolean actual = cigarParty.haveParty(50, false);
        boolean expected = true;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void havePartyTest_send_in_maxCigar_return_isWeekend() {
        //Arrange
        CigarParty cigarParty = new CigarParty();
        //Act
        boolean actual = cigarParty.haveParty(70, true);
        boolean expected = true;

        Assert.assertEquals(true, actual);
    }

    @Test
    public void havePartyTest_send_in_maxCigar_return_isNotWeekend() {
        //Arrange
        CigarParty cigarParty = new CigarParty();
        //Act
        boolean actual = cigarParty.haveParty(70, false);
        boolean expected = false;

        Assert.assertEquals(false, actual);
    }

    @Test
    public void havePartyTest_send_in_minCigar_return_isTheWeekend() {
        //Arrange
        CigarParty cigarParty = new CigarParty();
        //Act
        boolean actual = cigarParty.haveParty(30, true);
        boolean expected = false;

        Assert.assertEquals(expected, actual);
    }
}