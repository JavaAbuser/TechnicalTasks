package ru.rtech.internship;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Task5ExcelTest {

    @Test
    public void excelColumnNameToNumberTest() {
        assertThat(new Task5Excel().excelColumnNameToNumber("A")).isEqualTo(1);
        assertThat(new Task5Excel().excelColumnNameToNumber("Z")).isEqualTo(26);
        assertThat(new Task5Excel().excelColumnNameToNumber("AA")).isEqualTo(27);
        assertThat(new Task5Excel().excelColumnNameToNumber("ZZZ")).isEqualTo(18278);
        assertThat(new Task5Excel().excelColumnNameToNumber("ADC")).isEqualTo(783);
    }

}