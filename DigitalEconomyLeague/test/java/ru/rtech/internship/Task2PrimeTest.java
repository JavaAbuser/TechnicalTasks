package ru.rtech.internship;

import org.junit.Test;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class Task2PrimeTest {

    private Task2Prime task2Prime = new Task2Prime();

    @Test
    public void emptyListWhenNoPrimeElements() {
        assertThat(task2Prime.primeSquares(IntStream.of(4, 6, 8, 10, 15).boxed().collect(Collectors.toList())))
                .isEmpty();
    }

    @Test
    public void returnOneSquaredElement() {
        assertThat(task2Prime.primeSquares(IntStream.of(3, 6, 8, 10, 15,169).boxed().collect(Collectors.toList())))
                .hasSize(1)
                .contains(9);
    }

}