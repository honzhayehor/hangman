package input;

import java.util.Scanner;

public class CLIUserInput implements UserInput{
    private final Scanner scanner;

    public CLIUserInput(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public Character getUserInputChar() {
        while (true) {
            String line = scanner.nextLine();

            if (line.isEmpty()) {
                System.out.println("Input cannot be empty");
                continue;
            }

            char c = line.charAt(0);

            if (Character.isLetter(c)) {
                return c;
            }
            System.out.println("You should enter a letter only");
        }
    }

    @Override
    public String getUserInputString() {
        while (true) {
            String line = scanner.nextLine();

            if (line.isEmpty()) {
                System.out.println("Input cannot be empty");
                continue;
            }
            return line;
        }
    }
}
