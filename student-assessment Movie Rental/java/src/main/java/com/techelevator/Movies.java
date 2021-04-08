package com.techelevator;

import java.math.BigDecimal;

public class Movies {
    private String title;

    public Movies() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    private String format;


    public Movies(String slot, String name, BigDecimal price) {
        this.title = title;

        this.format = format;
    }

}
