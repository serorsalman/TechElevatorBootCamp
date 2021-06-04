package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class AnimalGroupNameTest {

    @Test
    public void getHerdTest_send_in_giraffe_return_Tower() {
        //Arrange
        AnimalGroupName animalGroupName = new AnimalGroupName();
        //Act
        String actual = animalGroupName.getHerd("giraffe");
        String expected = "Tower";

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getHerdTest_send_in_pigeon_return_Kit() {
        //Arrange
        AnimalGroupName animalGroupName = new AnimalGroupName();
        //Act
        String actual = animalGroupName.getHerd("pigeon");
        String expected = "Kit";

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getHerdTest_send_in_crocodile_return_Float() {
        //Arrange
        AnimalGroupName animalGroupName = new AnimalGroupName();
        //Act
        String actual = animalGroupName.getHerd("crocodile");
        String expected = "Float";

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getHerdTest_send_in_null_return_unknown() {
        //Arrange
        AnimalGroupName animalGroupName = new AnimalGroupName();
        //Act
        String actual = animalGroupName.getHerd("");
        String expected = "unknown";

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getHerdTest_send_in_rhino_return_Crash() {
        //Arrange
        AnimalGroupName animalGroupName = new AnimalGroupName();
        //Act
        String actual = animalGroupName.getHerd("rhino");
        String expected = "Crash";

        Assert.assertEquals(expected, actual);
    }
}