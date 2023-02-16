import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConcertTest {

    private Concert c1, c2;

    @BeforeEach
    void setup() {
         c1 = new Concert("Artist1", 10, 100);
         c2 = new Concert("Artist2", 1, 0);
    }

    @Test
    void constructor() {
        assertEquals("Artist1", c1.getArtist());
        assertEquals(10, c1.getTickets());
        assertEquals(100, c1.getWaitlist());

        assertEquals("Artist2", c2.getArtist());
        assertEquals(1, c2.getTickets());
        assertEquals(0, c2.getWaitlist());
    }

    @Test
    void purchaseTicket() {
        assertEquals(10, c1.getTickets());
        assertTrue(c1.purchaseTicket());
        assertEquals(9, c1.getTickets());
        assertTrue(c1.purchaseTicket());
        assertEquals(8, c1.getTickets());

        assertEquals(1, c2.getTickets());
        assertTrue(c2.purchaseTicket());
        assertEquals(0, c2.getTickets());
        assertFalse(c2.purchaseTicket());
        assertEquals(0, c2.getTickets());
    }

    @Test
    void addToWaitlist() {
        assertEquals(100, c1.getWaitlist());
        c1.addToWaitlist();
        assertEquals(101, c1.getWaitlist());
        c1.addToWaitlist();
        assertEquals(102, c1.getWaitlist());

        assertEquals(0, c2.getWaitlist());
        c2.addToWaitlist();
        assertEquals(1, c2.getWaitlist());
        c2.addToWaitlist();
        assertEquals(2, c2.getWaitlist());
    }
}