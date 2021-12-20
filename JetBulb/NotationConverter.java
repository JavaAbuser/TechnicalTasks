package JetBulb;

/**
 * @author Max Steblevskiy(JavaAbuser) on 20.12.21
 */
public class NotationConverter {
    public int toArabic(String romanNotation) throws InvalidValueException {
        if (romanNotation == null || romanNotation.isBlank()) {
            throw new InvalidValueException("String must contain only valid roman numerals\n" +
                    "[I, V, X, L, C, D, M].");
        }
        int result = 0;
        int value = 0;
        for (int i = romanNotation.length() - 1; i >= 0; i--) {
            switch (romanNotation.charAt(i)) {
                case 'M' -> value = 1000;
                case 'D' -> value = 500;
                case 'C' -> value = 100;
                case 'L' -> value = 50;
                case 'X' -> value = 10;
                case 'V' -> value = 5;
                case 'I' -> value = 1;
                default -> {
                    result = 0;
                    throw new InvalidValueException("String must contain only valid roman numerals\n" +
                            "[I, V, X, L, C, D, M].");
                }
            }
            result += (4 * value < result) ? -value : value;
        }
        return result;
    }
}
