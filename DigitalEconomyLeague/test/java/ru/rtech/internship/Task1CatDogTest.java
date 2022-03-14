package ru.rtech.internship;


import org.junit.Test;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class Task1CatDogTest {

    private Task1CatDog task1CatDog = new Task1CatDog();

    @Test
    public void handlecatDogCorrect() {
        assertThat(
                task1CatDog.catDog(
                        IntStream.range(1, 100)
                                .boxed()
                                .collect(Collectors.toList())
                ))
                .contains("3 - cat")
                .contains("5 - dog")
                .contains("15 - catdog")
                .doesNotContain("15 - dog")
                .doesNotContain("15 - cat")
                .contains("90 - catdog")
                .contains("99 - cat")
                .doesNotContainSequence("16", "1", "2");
    }

    @Test
    public void emptyListWhenNoFittingElements() {
        assertThat(task1CatDog.catDog(IntStream.range(1, 3).boxed().collect(Collectors.toList())))
                .isEmpty();
    }

}