package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringExercisesTest {

    @Test
    public void makeAbbaTest_tests_that_sends_in_hi_and_bye_and_returns_hibyebyehi() {
        //Arrange
        StringExercises stringExercises = new StringExercises();  // create object of class

        //Act
        String actual = stringExercises.makeAbba("hi", "bye");  //what actually comes back
        String expected = "hibyebyehi";  // what we expect the answer to be

        //Assert
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void makeAbbaTest_tests_that_sends_in_Yo_and_Alice_and_returns_YoAliceAliceYo(){
        //Arrange
        StringExercises stringExercises = new StringExercises();

        //Act
        String actual = stringExercises.makeAbba("Yo", "Alice");
        String expected = "YoAliceAliceYo";

        //Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void firstTwoTest_accepts_Hello_and_returns_He() {
        //Arrange
        StringExercises stringExercises = new StringExercises();

        //Act and Assert
        Assert.assertEquals("He", stringExercises.firstTwo("Hello"));

    }

    @Test
    public void firstTwoTest_accepts_A_and_returns_A(){
        StringExercises stringExercises = new StringExercises();

        Assert.assertEquals("A", stringExercises.firstTwo("A"));
    }
}