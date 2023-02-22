public class Concert {
    private String artist;
    private int available;
    private int waitlist;

    public Concert(String artist, int available) {
        this.artist = artist;
        this.available = available;
    }

    public String getArtist() {
        return artist;
    }

    public int getTickets() {
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
                "artist='" + artist + '\'' +
                ", available=" + available +
                ", waitlist=" + waitlist +
                '}';
    }
}
