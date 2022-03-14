package ru.rtech.internship;

import java.util.List;

public class Task3Sum {

    /**
     * Баллов за выполнение - 2
     *
     * На вход идет строка с числами и операциями сложения и вычитания. Например, 5+6-3. Унарных операций нет, то есть строка всегда начинается с положительного числа.
     * Функция должна вернуть результат выражения. Скобки учитывать не надо. Между числами и знаками может быть разное количество пробелов. Если во время
     * вычисления случилась ошибка и выражение вычислить не получается - вернуть null.
     */
    public Integer sum(String expression){
        int result = 0;
        String str = expression.replaceAll("\\s*", "");
        int counter = 0;
        for(int i = 0; i < str.toCharArray().length; i++){
            if(str.charAt(i) == '+' || str.charAt(i) == '-'){
                if(str.charAt(i) == '+'){
                    result += Integer.parseInt(str.subSequence(counter, i).toString());
                    counter = i + 1;
                } else if(str.charAt(i) == '-'){
                    result -= Integer.parseInt(str.subSequence(counter, i).toString());
                    counter = i + 1;
                }
            }
        }
        return result;
    }
}
