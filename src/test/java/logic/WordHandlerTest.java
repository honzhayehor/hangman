package logic;

import org.junit.jupiter.api.Test;

import java.lang.System;

import static org.junit.jupiter.api.Assertions.*;

class WordHandlerTest {

    @Test
    void testReturnCorrectMaskedWord() {
        WordHandler wh = new WordHandler("World");
        wh.offerLetter('w');
        String res = wh.getMaskedWord();
        assertEquals("w____", res);
    }

    @Test
    void testRaisesErrorWhenWordIsTooShort() {
        assertThrows(IllegalArgumentException.class, () -> new WordHandler("A"));
    }

    @Test
    void testReturnsFalseToWrongLetter() {
        assertFalse(new WordHandler("Mama").offerLetter('s'));
    }

    @Test
    void testRaisesErrorWhenSpaceIsDigitInsteadOfLetter() {
        assertThrows(IllegalArgumentException.class, () -> new WordHandler("ASD").offerLetter('1'));
    }

    @Test
    void testRaisesErrorWhenSpaceIsEnteredInsteadOfLetter() {
        assertThrows(IllegalArgumentException.class, () -> new WordHandler("ASD").offerLetter(' '));
    }

}