package com.techelevator;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;



@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoopsAndArrayExercisesTest {

    @Test
    public void middleWayTest_sends_in_1_2_3_and_4_5_6_returns_2_5() {
        //Arrange
        LoopsAndArrayExercises loopsAndArrayExercises =
                new LoopsAndArrayExercises();
        int[] a = {1, 2, 3};
        int[] b = {4, 5, 6};

        //Act
        int[] actual = loopsAndArrayExercises.middleWay(a, b);
        int[]expected = {2, 5};

        //Assert
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void maxEnd3() {
    }
}