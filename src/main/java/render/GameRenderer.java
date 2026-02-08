package render;

public interface GameRenderer {
    void renderWord(String word);
    void renderSurrounding(int attemptsIn, int attemptsCur);
}
