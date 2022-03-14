package ru.rtech.internship;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Task2Prime {

    /**
     * Баллов за выполнение - 1
     * <p>
     * На вход идет непустой список с числами > 0. Нужно вернуть список с квадратами простых чисел.
     */
    public List<Integer> primeSquares(List<Integer> numbers) {
        List<Integer> listOfPrimeSquares = numbers
                .stream()
                .filter(n -> isPrime(n) == true)
                .map(n -> n * n)
                .collect(Collectors.toList());

        return listOfPrimeSquares;
    }

    private boolean isPrime(int number) {
        boolean isPrime = false;
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                isPrime = false;
                break;
            } else {
                isPrime = true;
            }
        }
        return isPrime;
    }
}
