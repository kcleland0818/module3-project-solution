import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConcertRepositoryTest {

    private ConcertRepository repository;

    @BeforeEach
    void setup() {
        repository = new ConcertRepository();
    }

    @Test
    void findAll() {
        Concert[] concerts = repository.findAll();

        assertEquals(3, concerts.length);

        assertEquals("Taylor Swift", concerts[0].getArtist());
        assertEquals(5, concerts[0].getTickets());
        assertEquals(10000, concerts[0].getWaitlist());

        assertEquals("The Weeknd", concerts[1].getArtist());
        assertEquals(2, concerts[1].getTickets());
        assertEquals(5000, concerts[1].getWaitlist());

        assertEquals("Harry Styles", concerts[2].getArtist());
        assertEquals(100, concerts[2].getTickets());
        assertEquals(1000, concerts[2].getWaitlist());

    }

    @Test
    void findByArtist() {
        Concert c1 = repository.findByArtist("Taylor Swift");
        assertEquals("Taylor Swift", c1.getArtist());
        assertEquals(5, c1.getTickets());
        assertEquals(10000, c1.getWaitlist());

        Concert c2 = repository.findByArtist("The Weeknd");
        assertEquals("The Weeknd",c2.getArtist());
        assertEquals(2, c2.getTickets());
        assertEquals(5000, c2.getWaitlist());

    }
}