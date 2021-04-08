package com.techelevator;

import java.math.BigDecimal;

public class MovieRental {
    String Title;
    String format;
    boolean isPremiumMovie;
    BigDecimal rentalPrice;
    int late;

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public boolean isPremiumMovie() {
        return isPremiumMovie;
    }

    public void setPremiumMovie(boolean premiumMovie) {
        isPremiumMovie = premiumMovie;
    }

    public BigDecimal getRentalPrice() {
        return rentalPrice;
    }

    public void setRentalPrice(BigDecimal rentalPrice) {
        this.rentalPrice = rentalPrice;
    }

    public int getLate() {
        return late;
    }

    public void setLate(int late) {
        this.late = late;
    }

    public MovieRental(String title, String format, boolean isPremiumMovie) {
        Title = title;
        this.format = format;
        this.isPremiumMovie = isPremiumMovie;
    }
    public void daysLate(){


    }
}
