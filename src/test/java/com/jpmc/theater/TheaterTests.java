package com.jpmc.theater;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TheaterTests {

    /**
     * Test for schedule
     */
    @Test
    void testSchedule() {
        Theater theater = new Theater(LocalDateProvider.singleton());
        assertEquals("Turning Red", theater.getSchedule().get(0).getMovie().getTitle());
        assertEquals(11, theater.getSchedule().get(0).getMovie().getTicketPrice());
        assertEquals(0, theater.getSchedule().get(0).getMovie().getSpecialCode());
    }

    /**
     * Test for reserve method
     */
    @Test
    void testReservation() {
        Theater theater = new Theater(LocalDateProvider.singleton());
        Customer customer = new Customer("Monica Venugopal");
        Reservation reservation = theater.reserve(customer, 2, 2);
        assertEquals("Spider-Man: No Way Home", reservation.getShowing().getMovie().getTitle());
        assertEquals("Monica Venugopal", reservation.getCustomer().getName());
        assertEquals(18.75, reservation.totalFee());
    }

    /**
     * Test to print movie schedule in simple test format
     */
    @Test
    void printMovieSchedule() {
        Theater theater = new Theater(LocalDateProvider.singleton());
        theater.printSchedule();
    }

    /**
     * Test to print movie schedule in json format
     */
    @Test
    void printMovieScheduleJson() {
        Theater theater = new Theater(LocalDateProvider.singleton());
        theater.printScheduleInJson();
    }
}
