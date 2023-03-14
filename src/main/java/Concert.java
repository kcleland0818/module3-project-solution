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

    public boolean purchaseTicket() {
        if (available > 0) {
            available--;
            return true;
        } else {
            return false;
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
