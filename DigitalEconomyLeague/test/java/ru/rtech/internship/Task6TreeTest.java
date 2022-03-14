package ru.rtech.internship;

import org.junit.Test;
import ru.rtech.internship.domain.Node;

import static org.assertj.core.api.Assertions.assertThat;

public class Task6TreeTest {

    private Task6Tree task6Tree = new Task6Tree();

    @Test
    public void sortSimpleTree() {
        Node root = new Node(
                new Node(null, null, "1"),
                new Node(null, null, "3"),
                "2");
        assertThat(task6Tree.sortedTreeValues(root)).isEqualTo("1;2;3");
    }

    @Test
    public void checkTreeDoesNotUseLexographicSort() {
        Node root = new Node(
                new Node(null, null, "1"),
                new Node(null, null, "10"),
                "2");
        assertThat(task6Tree.sortedTreeValues(root)).isEqualTo("1;2;10");
    }

    @Test
    public void complexTree() {
        Node root = new Node(
                new Node(
                        new Node(null, null, "1"),
                        new Node(null, null, "2"),
                        "3"),
                new Node(
                        null,
                        new Node(
                                new Node(null, null, "4"),
                                null,
                                "5"),
                        "6"),
                "7");
        assertThat(task6Tree.sortedTreeValues(root)).isEqualTo("1;2;3;4;5;6;7");
    }
}