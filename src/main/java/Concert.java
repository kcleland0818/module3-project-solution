public class Concert {
    private String artist;
    private int tickets;
    private int waitlist;

    public Concert(String artist, int tickets, int waitlist) {
        this.artist = artist;
        this.tickets = tickets;
        this.waitlist = waitlist;
    }

    public String getArtist() {
        return artist;
    }

    public int getTickets() {
        return tickets;
    }

    public int getWaitlist() {
        return waitlist;
    }

    public boolean purchaseTicket() {
        if (tickets > 0) {
            tickets--;
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
                "artist='" + artist + '\'' +
                ", tickets=" + tickets +
                ", waitlist=" + waitlist +
                '}';
    }
}
