import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ConcertController controller = new ConcertController();
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
                    controller.displayConcerts();
                    break;
                case "p":
                    System.out.println("Enter the artist name:");
                    controller.purchaseTicket( scanner.nextLine() );
                    break;
                case "w":
                    System.out.println("Enter the artist name:");
                    controller.addToWaitlist( scanner.nextLine() );
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