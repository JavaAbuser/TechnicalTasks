package ru.rtech.internship;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Task3SumTest {

    private Task3Sum task3Sum = new Task3Sum();

    @Test
    public void return5whenSum2And3() {
        assertThat(task3Sum.sum("2+3")).isEqualTo(5);
    }

    @Test
    public void multiDigitPositiveTests() {
        assertThat(task3Sum.sum("990+10+5")).isEqualTo(1005);
        assertThat(task3Sum.sum("9+100+5")).isEqualTo(114);
        assertThat(task3Sum.sum("30+30+100+10000")).isEqualTo(10160);
        assertThat(task3Sum.sum("30+30+100+10000-10000")).isEqualTo(160);
    }

    @Test
    public void return7ForComlexExpression() {
        assertThat(task3Sum.sum("2+3-5+7-3+3")).isEqualTo(7);
    }

    @Test
    public void nullWhenCannotCalculateExpression() {
        assertThat(task3Sum.sum("2+a-3")).isNull();
        assertThat(task3Sum.sum("2++3-3")).isNull();
        assertThat(task3Sum.sum("2---4")).isNull();
    }

}