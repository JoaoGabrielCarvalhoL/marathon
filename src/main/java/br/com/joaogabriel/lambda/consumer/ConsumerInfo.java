package br.com.joaogabriel.lambda.consumer;

import java.util.List;

public class ConsumerInfo {
    public static void main(String[] args) {
        List<String> name = List.of("João", "Gabriel", "Carvalho", "Lopes", "Cruz");
        forEach(name, System.out::println);
    }

    private static <T> void forEach(List<T> data, Consumer<T> consumer) {
        data.forEach(consumer::accept);
    }
}
