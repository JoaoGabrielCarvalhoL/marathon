package br.com.joaogabriel.collections.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListConverter {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
        Integer[] array = numbers.toArray(new Integer[0]); //when use zero, the compiler use reflection to discovery size of a list
        numbers.forEach(System.out::println);
        for (Integer number : array) {
            System.out.println(number);
        }

        List<Integer> list = Arrays.stream(array).toList();
        list.forEach(System.out::println);
    }
}
