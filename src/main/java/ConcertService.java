public class ConcertService {
    // hardcode size 3
    private  ConcertRepository repository = new ConcertRepository(3);

    public void add(String artist, int available) {
        Concert concert = repository.findByArtist(artist);
        if (concert == null) {
            if (repository.add(new Concert(artist, available))) {
                System.out.println("Added concert");
            }
            else {
                System.out.println("Unable to add concert");
            }
        }
        else {
            System.out.println("Unable to add concert");
        }
    }
    public void displayConcerts() {
        for (int i=0; i<repository.getCurrentSize(); i++) {
            System.out.println(repository.get(i));
        }
    }

    public void purchaseTicket(String artist) {
        Concert concert = repository.findByArtist(artist);
        if (concert == null) {
            System.out.printf("No concert for %s%n", artist);
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
            System.out.printf("No concert for %s%n", artist);
        }
        else {
            concert.addToWaitlist();
            System.out.println("Added to waitlist");
        }
    }

}
