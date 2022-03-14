package ru.rtech.internship;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
//        Task1CatDog task1CatDog = new Task1CatDog();
        List<Integer> numbers = new ArrayList<>();
        numbers.add(20);
        numbers.add(9);
        numbers.add(15);
        numbers.add(30);
        numbers.add(7);
//        System.out.println(task1CatDog.catDog(numbers));

        Task2Prime task2Prime = new Task2Prime();
        System.out.println(task2Prime.primeSquares(numbers));
    }
}
