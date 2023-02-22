import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConcertRepositoryTest {


    @Test
    void size5() {
        ConcertRepository repository = new ConcertRepository(5);
        assertEquals(0, repository.getCurrentSize());

        // add 5 concerts
        for (int i=0; i<5; i++) {
            assertTrue(repository.add(new Concert("Artist" + i, i*1000)));
            assertNotNull(repository.get(i));
            assertEquals(i + 1, repository.getCurrentSize());
        }

        //array full, can't add another concert
        assertFalse(repository.add(new Concert("Another artist", 100)));
        assertEquals(5, repository.getCurrentSize());
    }

    @Test
    void add() {
        // array can hold 3 concerts
        ConcertRepository repository = new ConcertRepository(3);

        assertTrue(repository.add(new Concert("The Weeknd", 1000)));
        assertTrue(repository.add(new Concert("Taylor Swift", 500)));
        assertTrue(repository.add(new Concert("Harry Styles", 20000)));
        assertEquals(3, repository.getCurrentSize());

        assertEquals("The Weeknd", repository.get(0).getArtist());
        assertEquals("Taylor Swift", repository.get(1).getArtist());
        assertEquals("Harry Styles", repository.get(2).getArtist());
    }

    @Test
    public void getOutOfBounds() {
        ConcertRepository repository = new ConcertRepository(3);
        assertTrue(repository.add(new Concert("artist1", 1000)));
        assertTrue(repository.add(new Concert("artist2", 1000)));
        assertTrue(repository.add(new Concert("artist3", 1000)));
        // out of bounds
        assertNull(repository.get(-1));
        assertNull(repository.get(3));
    }


    @Test
    void findByArtist() {
        ConcertRepository repository = new ConcertRepository(2);

        repository.add(new Concert("Taylor Swift", 1000));
        repository.add(new Concert("The Weeknd", 500));

        Concert c1 = repository.findByArtist("Taylor Swift");
        assertEquals("Taylor Swift", c1.getArtist());
        assertEquals(1000, c1.getTickets());
        assertEquals(0, c1.getWaitlist());

        Concert c2 = repository.findByArtist("The Weeknd");
        assertEquals("The Weeknd",c2.getArtist());
        assertEquals(500, c2.getTickets());
        assertEquals(0, c2.getWaitlist());

        //unknown artist
        Concert c3 = repository.findByArtist("Unknown Singer");
        assertNull(c3);

    }
}