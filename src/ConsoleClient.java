import java.util.Scanner;

public class ConsoleClient {
    private boolean run;

    private Scanner input;

    private String inputString;
    private String pattern;

    public ConsoleClient() {
        run = true;
        input = new Scanner(System.in);

        System.out.println("The console will request user input as a string and a pattern which must be found within the input string.\n" +
                           "Enter 'QUIT' to exit this console app.\n\n");

        do {
            System.out.print("Please enter a string: ");
            inputString = input.nextLine();

            System.out.print("Please enter a pattern: ");
            pattern = input.nextLine();

            if (inputString.equals("QUIT")) {
                run = false;
            }
        } while (run);

        quitClient();
    }

    private void quitClient() {
        input.close();
        System.out.println("Goodbye!");
        System.exit(0);
    }

    public static void main(String[] args) {
        new ConsoleClient();
    }
}