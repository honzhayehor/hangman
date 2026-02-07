package logic;

public class Player {
    private boolean isAlive = true;

    public boolean makeMove(char c, final WordHandler wordHandler) {
        return wordHandler.offerLetter(c);
    }

    public boolean isAlive() {
        return isAlive;
    }
    public void setAlive(boolean alive) {
        isAlive = alive;
    }

}
