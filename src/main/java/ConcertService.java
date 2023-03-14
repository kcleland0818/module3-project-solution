import java.util.List;

public class ConcertService {

    private  ConcertRepository repository = new ConcertRepository();

    public void addConcert(String performer, int available) {
        Concert concert = repository.findByPerformer(performer);
        if (concert == null) {
            if (repository.add(new Concert(performer, available))) {
                System.out.println("Added concert");
            }
            else {
                System.out.println("Unable to add concert");
            }

        }
        else {
            System.out.printf("Concert with %s already exists. Unable to add concert%n", performer);
        }
    }
    public void displayConcerts() {
        List<Concert> concerts = repository.getAllConcerts();
        for (Concert concert : concerts) {
            System.out.println(concert);
        }
    }

    public void purchaseTicket(String performer) {
        Concert concert = repository.findByPerformer(performer);
        if (concert == null) {
            System.out.printf("No concert for %s%n", performer);
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

    public void addToWaitlist(String performer) {
        Concert concert = repository.findByPerformer(performer);
        if (concert == null) {
            System.out.printf("No concert for %s%n", performer);
        }
        else {
            concert.addToWaitlist();
            System.out.println("Added to waitlist");
        }
    }

}
