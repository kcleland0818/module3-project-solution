package ticket;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WalkupTicketTest {

    @Test
    void testWalkupTicket() {
        WalkupTicket ticket = new WalkupTicket(1);
        assertEquals(1, ticket.getTicketNumber());
        assertEquals(50.0, ticket.getPrice());
        assertEquals("Ticket Number = 1, Price = 50.00", ticket.toString());
    }
}
