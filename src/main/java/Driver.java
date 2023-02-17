import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {
        ConcertService service = new ConcertService();
        Scanner scanner = new Scanner(System.in);
        String prompt = "Select an action: d=display, p=purchase, w=waitlist, q=quit: ";
        String action;

        // Prompt the user for an action
        System.out.println(prompt);
        action = scanner.nextLine();

        // Loop until the user enters q to quit
        while (!action.equals("q")) {
            switch (action) {
                case "d":
                    service.displayConcerts();
                    break;
                case "p":
                    System.out.println("Enter the artist name:");
                    service.purchaseTicket( scanner.nextLine() );
                    break;
                case "w":
                    System.out.println("Enter the artist name:");
                    service.addToWaitlist( scanner.nextLine() );
                    break;
                default:
                    System.out.println("Invalid choice: " + action);
            }

            // get the next action
            System.out.println(prompt);
            action = scanner.nextLine();
        }
    }

} 