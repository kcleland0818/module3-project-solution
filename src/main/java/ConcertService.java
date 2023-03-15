import ticket.AdvanceTicket;
import ticket.StudentTicket;
import ticket.Ticket;
import ticket.WalkupTicket;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class ConcertService {

    private final ConcertRepository repository = new ConcertRepository();

    public void addConcert(String performer, int available, LocalDate concertDate) {
        Concert concert = repository.findByPerformer(performer);
        if (concert == null) {
            if (repository.add(new Concert(performer, available, concertDate))) {
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

    public void purchaseTicket(String performer, boolean isStudent, LocalDate purchaseDate) {
        Concert concert = repository.findByPerformer(performer);
        if (concert == null) {
            System.out.printf("No concert for %s%n", performer);
        }
        else {
            boolean canPurchase = determineTicket(concert, purchaseDate, isStudent);
            if (canPurchase) {
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

    private boolean determineTicket(Concert concert, LocalDate purchaseDate, boolean isStudent) {

        // Check to see if the purchase date is after the concert date
        if (purchaseDate.isAfter(concert.getConcertDate())) {
            return false;
        }

        Ticket ticket;
        int ticketNumber = concert.purchaseTicket();

        // If the ticket number is negative, then no more tickets were left to purchase
        if (ticketNumber < 0) {
            return false;
        } else if (isStudent) {
            ticket = new StudentTicket(ticketNumber);
        } else if (purchaseDate.isEqual(concert.getConcertDate())) {
            // If the ticket is being bought on the day of, this is a walk-up ticket
            ticket = new WalkupTicket(ticketNumber);
        } else {
            // Calculate the days between the purchase date and the concert date to see how far in advance
            // the ticket is being bought
            int daysBeforeConcert = (int) ChronoUnit.DAYS.between(purchaseDate, concert.getConcertDate());
            ticket = new AdvanceTicket(ticketNumber, daysBeforeConcert);
        }

        System.out.println(ticket);
        return true;
    }

}
