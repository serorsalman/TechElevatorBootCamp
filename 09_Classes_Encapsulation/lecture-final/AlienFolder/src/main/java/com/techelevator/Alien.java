package com.techelevator;

//blueprint for all aliens
public class Alien {
    // define data members, or properties, instance variables, attributes
    // ALWAYS make them private!
    private String color;
    private boolean hasBigHead;
    private String planetOfOrigin;
    private String speciesName;

    // declare or define the behaviors or methods -- getters and setters
    // public so we can call the methods!
    public void setColor(String color){
        this.color = color;
    }

    public String getColor(){
        return this.color;
    }

    public void setHasBigHead(boolean hasBigHead){
        this.hasBigHead = hasBigHead;
    }

    public boolean getHasBigHead() {
        return this.hasBigHead;
    }

    public void setPlanetOfOrigin(String planetOfOrigin){
        this.planetOfOrigin = planetOfOrigin;
    }

    public String getPlanetOfOrigin(){
        return this.planetOfOrigin;
    }

    public void setSpeciesName(String speciesName){
        this.speciesName = speciesName;
    }

    public String getSpeciesName(){
        return this.speciesName;
    }
}
