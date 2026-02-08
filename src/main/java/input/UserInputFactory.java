package input;

import java.util.Scanner;

public class UserInputFactory {
    public static UserInput getUserInput(UserInputType uit) {
        return switch (uit) {
            case CLI -> new CLIUserInput(new Scanner(System.in));
            case GUI -> null;
        };
    }
}
