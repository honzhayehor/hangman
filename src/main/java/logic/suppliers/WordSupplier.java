package logic.suppliers;

import java.util.List;
import java.util.Random;

public interface WordSupplier {
    String supplyWords();

    public static <E> E getRandomElement(List<E> list) {
        if (list == null || list.isEmpty()) {
            return null; // Handle empty or null list
        }

        Random random = new Random();
        int randomIndex = random.nextInt(list.size()); // Generate a random index
        return list.get(randomIndex); // Retrieve the element at the random index
    }
}
