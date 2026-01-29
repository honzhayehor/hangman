package logic;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RandomWordsAPIWordSupplierTest {

    @Test
    void testListIsNotEmpty() {
        RandomWordsAPIWordSupplier rw = new RandomWordsAPIWordSupplier();
        List<String> listOfWords = rw.supplyWords(2);

        assertEquals(List.of("Hello", "World").size(), listOfWords.size());
    }

    @Test
    void testRaisesErrorWhenNegativeNumber() {
        RandomWordsAPIWordSupplier rw = new RandomWordsAPIWordSupplier();

        assertThrows(IllegalArgumentException.class, () -> rw.supplyWords(-1));
    }
}