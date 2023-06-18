package com.jpmc.theater;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReservationTests {

    @Test
    void totalFee() {
        Customer customer = new Customer("Jane Doe");
        Movie movie = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90), 12.5, 1);
        Showing showing = new Showing(movie,
                1,
                LocalDateTime.now()
        );
        Reservation reservation = new Reservation(customer, showing, 3);
        assertEquals("Jane Doe", reservation.getCustomer().getName());
        assertEquals("Spider-Man: No Way Home", reservation.getShowing().getMovie().getTitle());
        assertEquals(28.5, reservation.totalFee());
    }
}
