package com.jpmc.theater;

import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieTests {

    @Test
    void movieTest() {
        //Create new movie and check if all details.
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90), 12.5, 1);
        assertEquals("Spider-Man: No Way Home", spiderMan.getTitle());
        assertEquals(90, spiderMan.getRunningTime().toMinutes());
        assertEquals(12.5, spiderMan.getTicketPrice());
        assertEquals(1, spiderMan.getSpecialCode());
    }
}
