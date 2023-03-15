import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConcertRepositoryTest {

    private ConcertRepository repository;

    @BeforeEach
    void setUp() {
        repository = new ConcertRepository();
    }

    @Test
    void constructor() {

        // current size is 0 since no concerts have been added
        assertEquals(0, repository.getAllConcerts().size());
    }

    @Test
    void addGet1() {
        assertEquals(0, repository.getAllConcerts().size());

        // add a concert
        assertTrue(repository.add(new Concert("Artist0", 1000, "03/15/2023")));
        assertEquals(1, repository.getAllConcerts().size());

        // retrieve the concert using index 0
        Concert c = repository.get(0);
        assertEquals("Artist0", c.getPerformer());
        assertEquals(1000, c.getAvailable());

    }

    @Test
    void addGet5() {
        assertEquals(0, repository.getAllConcerts().size());

        // add 5 concerts
        for (int i = 0; i < 5; i++) {
            // add the concert
            assertTrue(repository.add(new Concert("Artist" + i, i * 1000, "03/15/2023")));

            // retrieve the concert using index i
            assertNotNull(repository.get(i));

            // confirm the current size
            assertEquals(i + 1, repository.getAllConcerts().size());
        }

        // confirm the size did not increase
        assertEquals(5, repository.getAllConcerts().size());
    }

    @Test
    void getConcertState() {
        // add 3 concerts
        assertTrue(repository.add(new Concert("The Weeknd", 1000, "03/15/2023")));
        assertTrue(repository.add(new Concert("Taylor Swift", 500, "03/16/2023")));
        assertTrue(repository.add(new Concert("Harry Styles", 20000, "03/17/2023")));
        assertEquals(3, repository.getAllConcerts().size());

        // confirm each concert was inserted in the correct array position
        assertEquals("The Weeknd", repository.get(0).getPerformer());
        assertEquals("Taylor Swift", repository.get(1).getPerformer());
        assertEquals("Harry Styles", repository.get(2).getPerformer());
    }

    @Test
    public void getOutOfBounds() {
        assertTrue(repository.add(new Concert("artist1", 1000, "03/15/2023")));
        assertTrue(repository.add(new Concert("artist2", 1000, "03/16/2023")));
        assertTrue(repository.add(new Concert("artist3", 1000, "03/17/2023")));

        // test that out of bounds index returns null
        assertNull(repository.get(-1));
        assertNull(repository.get(3));
    }


    @Test
    void findByPerformer() {
        repository.add(new Concert("Taylor Swift", 1000, "03/15/2023"));
        repository.add(new Concert("The Weekend", 500, "03/16/2023"));

        Concert c1 = repository.findByPerformer("Taylor Swift");
        assertEquals("Taylor Swift", c1.getPerformer());
        assertEquals(1000, c1.getAvailable());
        assertEquals(0, c1.getWaitlist());

        Concert c2 = repository.findByPerformer("The Weekend");
        assertEquals("The Weekend", c2.getPerformer());
        assertEquals(500, c2.getAvailable());
        assertEquals(0, c2.getWaitlist());

        //unknown performer
        Concert c3 = repository.findByPerformer("Unknown Singer");
        assertNull(c3);

    }

    @Test
    void caseInsensitiveFind() {
        repository.add(new Concert("Taylor Swift", 1000, "03/15/2023"));
        repository.add(new Concert("The Weekend", 500, "03/16/2023"));

        Concert c1 = repository.findByPerformer("TAYLOR swift");
        assertEquals("Taylor Swift", c1.getPerformer());
        assertEquals(1000, c1.getAvailable());
        assertEquals(0, c1.getWaitlist());

    }
}