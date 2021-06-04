package com.techelevator;

import org.junit.After;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class LoopsAndArrayExercisesTest {

    @Test
    public void middleWayTest_send_in_1_2_3_and_4_5_6_returns_2_5() {
        //Arrange create objects
        LoopsAndArrayExercises loopsAndArrayExercises = new LoopsAndArrayExercises() ;
        int [] a= {1, 2, 3};
        int [] b= {4, 5, 6};

        // Act seting expected and actual
        int [] actual= loopsAndArrayExercises.middleWay(a, b);
        int [] expected = {2, 5};
        // Assert
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void maxEnd3() {
    }
}