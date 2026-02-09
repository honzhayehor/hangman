package logic;

import input.UserInput;
import input.UserInputFactory;
import input.UserInputType;
import logic.suppliers.GameDifficulty;
import logic.suppliers.SupplierType;
import logic.suppliers.WordSupplier;
import logic.suppliers.WordSupplierFactory;
import render.GameRenderer;
import render.HangmanArt;

import java.util.Random;

public class GameSystem {
    private WordHandler wordHandler;
    private final WordSupplier ws;
    private final UserInput userInputHandler;
    private final int maxWrongGuesses;
    private int currentWrongGuesses = 0;

    public GameSystem(SupplierType supplierType, UserInputType uit, GameDifficulty gd) {
        ws = WordSupplierFactory.getSupplier(supplierType);
        userInputHandler = UserInputFactory.getUserInput(uit);
        wordHandler = new WordHandler(ws.supplyWords());
        maxWrongGuesses = gd.getMaxWrongGuesses();
    }

    public void start() {
        while (currentWrongGuesses <= maxWrongGuesses) {
            if (wordHandler.hasWon()) {
                System.out.println("You won!");
                return;
            }

            GameRenderer.renderWord(HangmanArt.byWrongGuesses(currentWrongGuesses));
            GameRenderer.renderWord(wordHandler.getMaskedWord());

            int remaining = maxWrongGuesses - currentWrongGuesses + 1;
            System.out.println("Remaining attempts: " + remaining);

            System.out.println("Please, write down a character:");
            char c = userInputHandler.getUserInputChar();

            if (!wordHandler.offerLetter(c)) {
                currentWrongGuesses++;
            }

        }
        GameRenderer.renderWord(HangmanArt.byWrongGuesses(currentWrongGuesses));
        GameRenderer.renderWord(wordHandler.getMaskedWord());
        System.out.println("You lost!");
    }
}
