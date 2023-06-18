package com.jpmc.theater;

import java.time.LocalDateTime;

public class Showing {
    private Movie movie;
    private int sequenceOfTheDay;
    private LocalDateTime showStartTime;
    private static final int MOVIE_CODE_SPECIAL = 1;
    private static final int FIRST_SHOW = 1;
    private static final int SECOND_SHOW = 2;
    private static final int DAY_SEVEN = 7;

    /**
     * Constructor
     *
     * @param movie            the movie
     * @param sequenceOfTheDay sequence of the day
     * @param showStartTime    show start time
     */
    public Showing(Movie movie, int sequenceOfTheDay, LocalDateTime showStartTime) {
        this.movie = movie;
        this.sequenceOfTheDay = sequenceOfTheDay;
        this.showStartTime = showStartTime;
    }

    public Movie getMovie() {
        return movie;
    }

    public LocalDateTime getStartTime() {
        return showStartTime;
    }

    public double getMovieFee() {
        return movie.getTicketPrice();
    }

    public int getSequenceOfTheDay() {
        return sequenceOfTheDay;
    }

    /**
     * Method to calculate the discount amount
     *
     * @param showSequence the show sequence
     * @return double
     */
    private double getDiscount(int showSequence) {
        if (showSequence < 1 || showSequence > 9) {
            throw new IllegalArgumentException("Show sequence must be between 1 and 9");
        }
        double specialDiscount = 0;
        double sequenceDiscount = 0;
        double discountOnDay7 = 1;
        double timeDiscount = 0;
        double discount = 0;
        // 20% discount for special movie
        if (MOVIE_CODE_SPECIAL == movie.getSpecialCode()) {
            specialDiscount = getMovieFee() * 0.2;
            discount = specialDiscount > discount ? specialDiscount : discount;
        }
        // 25% discount for movie showing between 11AM and 4PM
        if (showStartTime.getHour() >= 11 && showStartTime.getHour() < 16) {
            timeDiscount = movie.getTicketPrice() * 0.25;
            discount = timeDiscount > discount ? timeDiscount : discount;
        }
        // $1 discount for movie showing on 7th of the month
        if (showStartTime.getDayOfMonth() == DAY_SEVEN) {
            discount = discountOnDay7 > discount ? discountOnDay7 : discount;
        }
        // $3 discount for 1st show
        if (showSequence == FIRST_SHOW) {
            sequenceDiscount = 3;
        }
        // $2 discount for 2nd show
        if (showSequence == SECOND_SHOW) {
            sequenceDiscount = 2;
        }
        // biggest discount wins
        return Math.max(sequenceDiscount, discount);
    }

    /**
     * Method to calculate the fee with discount
     *
     * @return double
     */
    public double calculateFee() {
        return getMovieFee() - getDiscount(getSequenceOfTheDay());
    }
}
