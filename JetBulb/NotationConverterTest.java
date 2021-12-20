package JetBulb;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class NotationConverterTest {
    public static NotationConverter converter;

    @BeforeAll
    public static void createNotationConverter() {
        converter = new NotationConverter();
    }

    @Test
    public void mustBeNotNull() {
        Assertions.assertThrows(InvalidValueException.class, () -> {
            converter.toArabic(null);
        });
    }

    @Test
    public void mustBeNotEmpty() {
        Assertions.assertThrows(InvalidValueException.class, () -> {
            converter.toArabic("");
        });
    }

    @Test
    public void mustBeNotBlank() {
        Assertions.assertThrows(InvalidValueException.class, () -> {
            converter.toArabic("     ");
        });
    }

    @Test
    public void shouldBeWorkCorrect(){
        Assertions.assertEquals(18, converter.toArabic("XVIII"));
    }
}