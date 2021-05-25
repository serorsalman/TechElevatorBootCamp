package com.techelevator;

public class Elevator {
    //Instance variables
    private int currentFloor;
    private int numberOfFloors;
    private boolean doorOpen;

    // constructor
    public Elevator(int numberOfLevels) {
        this.numberOfFloors = numberOfLevels;
        this.currentFloor = 1;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public boolean isDoorOpen() {
        return doorOpen;
    }

    public void openDoor() {
        doorOpen = true;
    }

    public void closeDoor() {
        doorOpen = false;
    }

    public void goUp(int desiredFloor) {
        //sends the elevator upward to the desired floor as long as the door isn't open. The elevator can't go past last floor.
        if (doorOpen == false && desiredFloor > currentFloor && desiredFloor <= numberOfFloors) {
            currentFloor = desiredFloor;
        }
    }

    public void goDown(int desiredFloor) {
        //goDown(int desiredFloor) sends the elevator downward to the desired floor as long as the door isn't open. It can't go past floor one.
        if (doorOpen == false && desiredFloor < currentFloor && desiredFloor > 0) {
            currentFloor = desiredFloor;
        }
    }
}