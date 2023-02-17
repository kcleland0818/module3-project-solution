public class ConcertService {
    private  ConcertRepository repository = new ConcertRepository();

    public void displayConcerts() {
        for (Concert next : repository.findAll()) {
            System.out.println(next);
        }
    }

    public void purchaseTicket(String artist) {
        Concert concert = repository.findByArtist(artist);
        if (concert == null) {
            System.out.printf("No concerts for %s%n", artist);
        }
        else {
            boolean success = concert.purchaseTicket();
            if (success) {
                System.out.println("Ticket purchased");
            }
            else {
                System.out.println("Ticket unavailable");
            }
        }
    }

    public void addToWaitlist(String artist) {
        Concert concert = repository.findByArtist(artist);
        if (concert == null) {
            System.out.printf("No concerts for %s%n", artist);
        }
        else {
            concert.addToWaitlist();
            System.out.println("Added to waitlist");
        }
    }
}
