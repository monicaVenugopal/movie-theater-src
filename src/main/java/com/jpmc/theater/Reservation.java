package com.jpmc.theater;

public class Reservation {
    private Customer customer;
    private Showing showing;
    private int audienceCount;

    public Customer getCustomer() {
        return customer;
    }

    public Showing getShowing() {
        return showing;
    }

    /**
     * Constructor
     *
     * @param customer      the customer
     * @param showing       the showing
     * @param audienceCount the audience count
     */
    public Reservation(Customer customer, Showing showing, int audienceCount) {
        this.customer = customer;
        this.showing = showing;
        this.audienceCount = audienceCount;
    }

    /**
     * Method to calculate total fee
     *
     * @return double total fee
     */
    public double totalFee() {
        return showing.calculateFee() * audienceCount;
    }
}