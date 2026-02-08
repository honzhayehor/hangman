package logic;

import input.UserInput;
import input.UserInputFactory;
import input.UserInputType;
import logic.suppliers.SupplierType;
import logic.suppliers.WordSupplier;
import logic.suppliers.WordSupplierFactory;

import java.util.Random;

public class GameSystem {
    private int attempts;
    private WordHandler wordHandler;
    private final Player player;
    private final WordSupplier ws;
    private final UserInput userInputHandler;

    public GameSystem(SupplierType supplierType, Player pl, UserInputType uit) {
        player = pl;
        ws = WordSupplierFactory.getSupplier(supplierType);

        userInputHandler = UserInputFactory.getUserInput(uit);
    }

    public void main() {
        System.out.println("Would you like to play the 'Hangman' game? y/n");
        String answer = userInputHandler.getUserInputString();
        if (!answer.equals("y")) {
            end();
        }
        wordHandler = new WordHandler(ws.supplyWords());
        attempts = wordHandler.getAvailableAttempts();



    }
    private void end() {
        System.exit(0);
    }

}
