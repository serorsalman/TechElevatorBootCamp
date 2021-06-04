package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringExercisesTest {

    @Test
    public void makeAbbaTest_tests_that_sends_in_hi_and_bye_and_returns_hibyebyehi() {
        //Arrange-
        //first I need objects of the string exercise to hold what we are getting back
        StringExercises stringExercises = new StringExercises();

        //Act- what actually comes back
        //second we will get back a string
        String actual = stringExercises.makeAbba("hi", "bye");
        String expected = "hibyebyehi";

        //Assert
        Assert.assertEquals(expected,actual);

    }
    @Test
    public void makeAbbaTest_test_that_sends_in_Yo_and_Alice_and_returns_YoAliceAliceYo(){
        //Arrange
        StringExercises stringExercises = new StringExercises();

        //Act
        String actual = stringExercises.makeAbba("Yo", "Alice");
        String expected = "YoAliceAliceYo";

        //Assert
        Assert.assertEquals(expected,actual);

    }

    @Test
    public void firstTwoTest_accepts_Hello_and_returns_He() {
        //Arange
        StringExercises stringExercises= new StringExercises();

        //Act and assert togather
        Assert.assertEquals("He", stringExercises.firstTwo("Hello"));

    }
    @Test
    public void firstTwoTest_accepts_Hello_and_returns_A(){
        StringExercises stringExercises= new StringExercises();
        Assert.assertEquals("A", stringExercises.firstTwo("A"));
    }
}