package br.com.joaogabriel.lambda.function;

import java.util.ArrayList;
import java.util.List;

public class FunctionInfo {
    public static void main(String[] args) {
        List<String> name = List.of("João", "Gabriel", "Carvalho", "Lopes", "Cruz");
        List<Integer> map = map(name, String::length);
        System.out.println(map);
    }

    private static <T, R> List<R> map(List<T> data, Function<T, R> function) {
        List<R> result = new ArrayList<>();
        for (T element : data) {
            R apply = function.apply(element);
            result.add(apply);
        }
        return result;

    }
}
