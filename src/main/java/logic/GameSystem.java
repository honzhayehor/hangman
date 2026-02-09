package logic;

import input.UserInput;
import input.UserInputFactory;
import input.UserInputType;
import logic.suppliers.GameDifficulty;
import logic.suppliers.SupplierType;
import logic.suppliers.WordSupplier;
import logic.suppliers.WordSupplierFactory;

import java.util.Random;

public class GameSystem {
    private WordHandler wordHandler;
    private final Player player;
    private final WordSupplier ws;
    private final UserInput userInputHandler;
    private final int maxWrongGuesses;
    private int attempts = 0;

    public GameSystem(SupplierType supplierType, Player pl, UserInputType uit, GameDifficulty gd) {
        player = pl;
        ws = WordSupplierFactory.getSupplier(supplierType);
        userInputHandler = UserInputFactory.getUserInput(uit);
        maxWrongGuesses = gd.getMaxWrongGuesses();
    }

    public void main() {
        while (attempts < maxWrongGuesses) {
            break;
        }
        // TODO: Finish method
    }
    private void end() {
        System.exit(0);
    }

}
