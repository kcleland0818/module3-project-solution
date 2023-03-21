package ticket;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentTicketTest {

    @Test
    void testStudentTicket() {
        StudentTicket ticket = new StudentTicket(1);
        assertEquals(1, ticket.getTicketNumber());
        assertEquals(25.0, ticket.getPrice());
        assertEquals("Ticket Number = 1, Price = 25.00", ticket.toString());
    }
}
