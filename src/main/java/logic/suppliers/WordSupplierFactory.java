package logic.suppliers;

public class WordSupplierFactory {
    public static WordSupplier getSupplier(SupplierType sp) {
        return switch (sp) {
            case API -> new RandomWordsAPIWordSupplier();
            case CSV -> new CSVWordSupplier();
        };
    }
}
