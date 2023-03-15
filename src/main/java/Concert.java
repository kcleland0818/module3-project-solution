public class Concert {

    private String performer;
    private int available;
    private int waitlist;

    public Concert(String performer, int available) {
        this.performer = performer;
        this.available = available;
    }

    public String getPerformer() {
        return performer;
    }

    public int getAvailable() {
        return available;
    }

    public int getWaitlist() {
        return waitlist;
    }

    /**
     * If there are still tickets available, return a positive integer with the ticket number
     * If there are no tickets available, return a negative integer
     * @return
     */
    public int purchaseTicket() {
        if (available > 0) {
            int ticketNumber = available;
            available--;
            return ticketNumber;
        } else {
            // Return a negative number to represent a ticket could not be purchased
            return -1;
        }
    }

    public void addToWaitlist() {
        waitlist++;
    }

    @Override
    public String toString() {
        return "Concert{" +
                "performer='" + performer + '\'' +
                ", available=" + available +
                ", waitlist=" + waitlist +
                '}';
    }
}
