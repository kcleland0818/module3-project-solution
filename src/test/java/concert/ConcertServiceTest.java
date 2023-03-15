package concert;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ConcertServiceTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private ConcertService concertService;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
        concertService = new ConcertService();
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void duplicateAdd() {
        concertService.addConcert("Taylor Swift" , 100, LocalDate.of(2023, 3, 15));
        concertService.addConcert("Taylor Swift" , 200, LocalDate.of(2023, 3, 15));
        assertEquals("Added concert\n" +
                        "concert.Concert with Taylor Swift already exists. Unable to add concert",
                outputStreamCaptor.toString().trim());
    }

    @Test
    void displayEmpty() {
        concertService.displayConcerts();
        assertEquals("", outputStreamCaptor.toString().trim());
    }

    @Test
    void displayNonEmpty() {
        concertService.addConcert("Taylor Swift" , 100, LocalDate.of(2023, 3, 15));
        concertService.addConcert("The Weekend", 5000, LocalDate.of(2023, 3, 16));
        concertService.displayConcerts();
        assertEquals("Added concert\n" +
                     "Added concert\n" +
                     "concert.Concert{performer='Taylor Swift', available=100, waitlist=0, concertDate=2023-03-15}\n" +
                     "concert.Concert{performer='The Weekend', available=5000, waitlist=0, concertDate=2023-03-16}",
                     outputStreamCaptor.toString().trim());
    }



    @Test
    void purchaseTicketSoldOutTest() {
        concertService.addConcert("Taylor Swift" , 3, LocalDate.of(2023, 3, 15));
        concertService.purchaseTicket("Taylor Swift", false, LocalDate.of(2023, 3, 15));
        concertService.purchaseTicket("Taylor Swift", false, LocalDate.of(2023, 3, 15));
        concertService.purchaseTicket("Taylor Swift", false, LocalDate.of(2023, 3, 15));
        // sold out, ticket unavailable
        concertService.purchaseTicket("Taylor Swift", false, LocalDate.of(2023, 3, 15));
        assertEquals("Added concert\n" +
                        "ticket.Ticket Number = 3, Price = 50.00\n" +
                        "ticket.Ticket purchased\n" +
                        "ticket.Ticket Number = 2, Price = 50.00\n" +
                        "ticket.Ticket purchased\n" +
                        "ticket.Ticket Number = 1, Price = 50.00\n" +
                        "ticket.Ticket purchased\n" +
                        "ticket.Ticket unavailable",
                outputStreamCaptor.toString().trim());
    }

    @Test
    void purchaseTicketUnknownArtist() {
        concertService.addConcert("Taylor Swift" , 1000, LocalDate.of(2023, 3, 15));
        concertService.purchaseTicket("Unknown Singer", false, LocalDate.of(2023, 3, 15));
        assertEquals("Added concert\n" +
                      "No concert for Unknown Singer",
                outputStreamCaptor.toString().trim());
    }

    @Test
    void testPurchaseTicketStudent() {
        concertService.addConcert("Taylor Swift" , 3, LocalDate.of(2023, 3, 15));
        concertService.purchaseTicket("Taylor Swift", true, LocalDate.of(2023, 3, 15));
        assertEquals("Added concert\n" +
                        "ticket.Ticket Number = 3, Price = 25.00\n" +
                        "ticket.Ticket purchased",
                outputStreamCaptor.toString().trim());
    }

    @Test
    void testPurchaseTicketAdvanceLessThan10() {
        concertService.addConcert("Taylor Swift" , 3, LocalDate.of(2023, 3, 15));
        concertService.purchaseTicket("Taylor Swift", false, LocalDate.of(2023, 3, 14));
        assertEquals("Added concert\n" +
                        "ticket.Ticket Number = 3, Price = 40.00\n" +
                        "ticket.Ticket purchased",
                outputStreamCaptor.toString().trim());
    }

    @Test
    void testPurchaseTicketAdvance10Days() {
        concertService.addConcert("Taylor Swift" , 3, LocalDate.of(2023, 3, 15));
        concertService.purchaseTicket("Taylor Swift", false, LocalDate.of(2023, 3, 5));
        assertEquals("Added concert\n" +
                        "ticket.Ticket Number = 3, Price = 30.00\n" +
                        "ticket.Ticket purchased",
                outputStreamCaptor.toString().trim());
    }

    @Test
    void testPurchaseTicketAdvanceMoreThan10() {
        concertService.addConcert("Taylor Swift" , 3, LocalDate.of(2023, 3, 15));
        concertService.purchaseTicket("Taylor Swift", false, LocalDate.of(2023, 3, 1));
        assertEquals("Added concert\n" +
                        "ticket.Ticket Number = 3, Price = 30.00\n" +
                        "ticket.Ticket purchased",
                outputStreamCaptor.toString().trim());
    }

    @Test
    void addToWaitlist() {
        concertService.addConcert("Taylor Swift" , 100, LocalDate.of(2023, 3, 15));
        concertService.addConcert("The Weeknd", 5000, LocalDate.of(2023, 3, 15));
        concertService.addToWaitlist("Taylor Swift");
        concertService.addToWaitlist("Taylor Swift");
        concertService.addToWaitlist("The Weeknd");
        // no concert
        concertService.addToWaitlist("Unknown Singer");

        assertEquals("Added concert\n" +
                     "Added concert\n" +
                     "Added to waitlist\n" +
                     "Added to waitlist\n" +
                     "Added to waitlist\n" +
                     "No concert for Unknown Singer",
                    outputStreamCaptor.toString().trim());
    }
}