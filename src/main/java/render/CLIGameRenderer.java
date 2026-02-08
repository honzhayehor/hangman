package render;

public class CLIGameRenderer implements GameRenderer{
    public void renderWord(String word) {
        System.out.println(word);
    }

    @Override
    public void renderSurrounding() {
        System.out.println("Hello world");
    }

}
