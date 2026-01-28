package logic;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;



class CSVWordSupplierTest {

    private final CSVWordSupplier csv = new CSVWordSupplier();

    @Test
    void testReturnsListWithCorrectWords() {
        List<String> wordList = csv.supplyWords(8);
        List<String> expected = List.of("phone", "charger", "cup", "computer", "website", "spooky", "skeleton", "game");

        assertEquals(expected, wordList);
    }

    @Test
    void testReturnsExactlyTwoWords() {
        List<String> wordList = csv.supplyWords(2);
        List<String> expected = List.of("phone", "charger");

        assertEquals(expected.size(), wordList.size());

    }

    @Test
    void testRaisesErrorWhenNegativeAmountOfWordsOrZeroRequested() {
        assertThrows(IllegalArgumentException.class,() -> csv.supplyWords(-1));
    }

    @Test
    void testRaisesErrorWhenCSVDoesNotExist() {
        CSVWordSupplier supplier = new CSVWordSupplier();
        supplier.setCSV_PATH("");
        assertThrows(RuntimeException.class, () -> supplier.supplyWords(2));
    }
}