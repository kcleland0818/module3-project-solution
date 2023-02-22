import java.util.InputMismatchException;
import java.util.Scanner;

public class Driver {

    private static ConcertService service = new ConcertService();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String prompt = "Select an action: a=add concert, d=display all concerts, p=purchase ticket, w=add to waitlist, q=quit: ";
        String action;

        // Prompt the user for an action

        // Loop until the user enters q to quit
        do {
            System.out.println(prompt);
            action = scanner.nextLine();

            switch (action) {
                case "a":
                    System.out.println("Enter the performer's name:");
                    String performer = scanner.nextLine();
                    try {
                        System.out.println("Enter the number of available tickets:");
                        int available = scanner.nextInt();
                        scanner.nextLine();  //consume the rest of the input
                        service.addConcert(performer, available);
                    }
                    catch (InputMismatchException e) {
                        System.out.println("Value was not an integer");
                    }
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

} 