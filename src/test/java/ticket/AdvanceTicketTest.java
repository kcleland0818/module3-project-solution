package ticket;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AdvanceTicketTest {

    @Test
    void testAdvanceTicket10Days() {
        AdvanceTicket ticket = new AdvanceTicket(1, 10);
        assertEquals(1, ticket.getTicketNumber());
        assertEquals(10, ticket.getDaysBeforeConcert());
        assertEquals(30.0, ticket.getPrice());
        assertEquals("ticket.Ticket Number = 1, Price = 30.00", ticket.toString());
    }

    @Test
    void testAdvanceTicketMoreThan10Days() {
        AdvanceTicket ticket = new AdvanceTicket(2, 12);
        assertEquals(2, ticket.getTicketNumber());
        assertEquals(12, ticket.getDaysBeforeConcert());
        assertEquals(30.0, ticket.getPrice());
    }

    @Test
    void testAdvanceTicketLessThan10Days() {
        AdvanceTicket ticket = new AdvanceTicket(3, 9);
        assertEquals(3, ticket.getTicketNumber());
        assertEquals(9, ticket.getDaysBeforeConcert());
        assertEquals(40.0, ticket.getPrice());
    }
}

