package ru.rtech.internship;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Task4StonesTest {

    @Test
    public void peopleAndStonesTest() {
        assertThat(new Task4Stones().peopleAndStones(5, 3)).hasSize(5).containsExactly(1, 2, 0, 0, 0);
        assertThat(new Task4Stones().peopleAndStones(2, 3)).hasSize(2).containsExactly(1, 2);
        assertThat(new Task4Stones().peopleAndStones(3, 10)).hasSize(3).containsExactly(5, 2, 3);
        assertThat(new Task4Stones().peopleAndStones(4, 2)).hasSize(4).containsExactly(1, 1, 0, 0);
    }
}