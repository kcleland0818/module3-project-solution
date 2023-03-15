import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Driver {

    private static ConcertService service = new ConcertService();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String prompt = "Select an action: " +
                "a=add concert, " +
                "d=display all concerts, " +
                "p=purchase ticket, " +
                "w=add to waitlist," +
                " q=quit: ";
        String action;

        // Prompt the user for an action
        // Loop until the user enters q to quit
        do {
            System.out.println(prompt);
            action = scanner.nextLine();

            switch (action) {
                case "a":
                    addConcert();
                    break;
                case "d":
                    service.displayConcerts();
                    break;
                case "p":
                    System.out.println("Enter the performer's name:");
                    service.purchaseTicket( scanner.nextLine() );
                    break;
                case "w":
                    System.out.println("Enter the performer's name:");
                    service.addToWaitlist( scanner.nextLine() );
                    break;
                case "q":
                    break;
                default:
                    System.out.println("Invalid choice: " + action);
            }
        }
        while (!action.equals("q"));
    }

    private static void addConcert() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the performer's name:");
        String performer = scanner.nextLine();
        try {
            System.out.println("Enter the number of available tickets:");
            int available = scanner.nextInt();
            scanner.nextLine();    // Consume the rest of the input

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/uuuu")
                    .withResolverStyle(ResolverStyle.STRICT);
            System.out.println("Enter a date for the concert in the format of MM/dd/uuuu:");
            String concertDate = scanner.nextLine();

            // Validate the date
            LocalDate date = LocalDate.parse(concertDate, formatter);
            service.addConcert(performer, available, date);
        }
        catch (InputMismatchException e) {
            System.out.println("Number of available tickets was not an integer");
        } catch (DateTimeParseException e) {
            System.out.println("Concert date was not a valid date");
        }
    }

    private static void purchaseTicket() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the performer's name:");
        String performer = scanner.nextLine();
        System.out.println("Enter the type of ticket you'd like to purchase: " +
                "W for walk-up ticket, " +
                "A for advance ticket, " +
                "S for student ticket");
    }
}