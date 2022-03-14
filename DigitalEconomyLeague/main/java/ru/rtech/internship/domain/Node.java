package ru.rtech.internship.domain;

public class Node {
    private Node left;
    private Node right;
    private String value;

    public Node(Node left, Node right, String value) {
        this.left = left;
        this.right = right;
        this.value = value;
    }

    public Node left() {
        return left;
    }

    public Node right() {
        return right;
    }

    public String value() {
        return value;
    }
}
