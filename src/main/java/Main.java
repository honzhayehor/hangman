import input.UserInputType;
import logic.GameSystem;
import logic.suppliers.GameDifficulty;
import logic.suppliers.SupplierType;

public class Main {
    static void main() {
        GameSystem gs = new GameSystem(SupplierType.CSV, UserInputType.CLI, GameDifficulty.MEDIUM);
        gs.start();
    }
}
