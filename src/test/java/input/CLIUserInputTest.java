package input;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class CLIUserInputTest {

    private InputStream originalIn;
    private PrintStream originalOut;

    private CLIUserInput userInput;

    @BeforeEach
    void saveSystemStreams() {
        originalIn = System.in;
        originalOut = System.out;
    }

    @AfterEach
    void restoreSystemStreams() {
        System.setIn(originalIn);
        System.setOut(originalOut);
        userInput = null;
    }

    @Test
    void returnsCorrectCharacter() {
        setUpInMethod("csdfsdf\n");
        assertEquals('c', userInput.getUserInputChar());
    }

    @Test
    void returnsCorrectString() {
        setUpInMethod("csdfsdf\n");
        assertEquals("csdfsdf", userInput.getUserInputString());
    }

    @Test
    void printsUserInputIsFalse() {
        setUpInMethod("\nc\n");

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        char result = userInput.getUserInputChar();
        assertEquals('c', result);

        String output = out.toString(StandardCharsets.UTF_8);
        assertTrue(output.contains("Input cannot be empty"));
    }

    private void setUpInMethod(String data) {
        System.setIn(new ByteArrayInputStream(data.getBytes(StandardCharsets.UTF_8)));
        userInput = new CLIUserInput(new Scanner(System.in));
    }
}
