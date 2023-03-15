package ticket;

public class AdvanceTicket extends Ticket {

    private final int daysBeforeConcert;

    public AdvanceTicket(int ticketNumber, int daysBeforeConcert) {
        super(ticketNumber);
        this.daysBeforeConcert = daysBeforeConcert;
    }

    public int getDaysBeforeConcert() {
        return daysBeforeConcert;
    }

    @Override
    public double getPrice() {
        // If the ticket is purchased 10 or more days before the event, cost $30
        if (daysBeforeConcert >= 10) {
            return 30.0;
        } else {
            // ticket.Ticket is purchased fewer than 10 days before the concert, cost $40
            return 40.0;
        }
    }
}
