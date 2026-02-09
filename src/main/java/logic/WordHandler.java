package logic;

import java.util.HashSet;
import java.util.Set;

public class WordHandler {
    private final String word;
    private final Set<Character> setOfCorrectLetters;

    public WordHandler(String word) {
        this.word = validateWord(word);
        this.setOfCorrectLetters = new HashSet<>();
    }

    public String getMaskedWord() {
        StringBuilder wordMasked = new StringBuilder();
        for (Character c: word.toCharArray()) {
            if (isLetterGuessed(c)) {
                wordMasked.append(c);
            }
            else wordMasked.append('_');
        }
        return wordMasked.toString();
    }

    public boolean offerLetter(char c) {
        if (!Character.isLetter(c)) {
            throw new IllegalArgumentException("Error: You cannot offer anything that is not a letter");
        }
        c = Character.toLowerCase(c);

        if (word.indexOf(c) != -1) {
            setOfCorrectLetters.add(c);
            return true;
        }
        return false;
    }

    private boolean isLetterGuessed(char c) {
        return setOfCorrectLetters.contains(c);
    }

    private String validateWord(String word) {
        if (!word.matches("[a-zA-Z]+") || word.length() <= 1) {
            throw new IllegalArgumentException("Error: Cannot start game using word that contains 1 or less letters");
        }
        return word.toLowerCase();
    }
}
