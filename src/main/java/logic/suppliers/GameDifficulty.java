package logic.suppliers;

public enum GameDifficulty {
    EASY(8),
    MEDIUM(6),
    HARD(5);

    private final int maxWrongGuesses;

    GameDifficulty(int attempts) { this.maxWrongGuesses = attempts;}

    public int getMaxWrongGuesses() { return maxWrongGuesses;}
}
