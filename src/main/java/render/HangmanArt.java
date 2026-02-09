package render;

public final class HangmanArt {

    private HangmanArt() {}

    private static final String[] STAGES = {
            // 0 — початок
            """
          +---+
          |   |
              |
              |
              |
              |
        =========
        """,

            // 1 — голова
            """
          +---+
          |   |
          O   |
              |
              |
              |
        =========
        """,

            // 2 — тулуб
            """
          +---+
          |   |
          O   |
          |   |
              |
              |
        =========
        """,

            // 3 — ліва рука
            """
          +---+
          |   |
          O   |
         /|   |
              |
              |
        =========
        """,

            // 4 — обидві руки
            """
          +---+
          |   |
          O   |
         /|\\  |
              |
              |
        =========
        """,

            // 5 — ліва нога
            """
          +---+
          |   |
          O   |
         /|\\  |
         /    |
              |
        =========
        """,

            // 6 — обидві ноги
            """
          +---+
          |   |
          O   |
         /|\\  |
         / \\  |
              |
        =========
        """,

            // 7 — “погано”
            """
          +---+
          |   |
         [O   |
         /|\\  |
         / \\  |
              |
        =========
        """,

            // 8 — “дуже погано”
            """
          +---+
          |   |
         [O]  |
         /|\\  |
         / \\  |
              |
        =========
        """,

            // 9 — кінець гри
            """
          +---+
          |   |
         [O]  |
         /|\\  |
         / \\  |
          RIP |
        =========
        """
    };

    public static String byWrongGuesses(int wrongGuesses) {
        int index = Math.min(Math.max(wrongGuesses, 0), STAGES.length - 1);
        return STAGES[index];
    }

    public static int maxWrongGuesses() {
        return STAGES.length - 1;
    }
}