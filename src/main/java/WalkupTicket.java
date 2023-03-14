public class WalkupTicket extends Ticket {

    public WalkupTicket(int ticketNumber) {
        super(ticketNumber);
    }

    @Override
    public double getPrice() {
        // Walk-up tickets are purchased the day of the event and cost $50.
        return 50.0;
    }
}
