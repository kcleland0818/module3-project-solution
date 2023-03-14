import java.time.LocalDate;

public abstract class Ticket {

    private final int ticketNumber;

    public Ticket(int ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public abstract double getPrice();

    @Override
    public String toString() {
        return String.format("Ticket Number = %d, Price = %.2f", ticketNumber, getPrice());
    }
}
