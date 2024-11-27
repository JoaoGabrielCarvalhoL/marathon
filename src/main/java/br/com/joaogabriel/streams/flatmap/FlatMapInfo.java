package br.com.joaogabriel.streams.flatmap;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * FlatMap
 * Retrieve nested value */
public class FlatMapInfo {
    public static void main(String[] args) {
        List<List<String>> values = new ArrayList<>();
        List<String> graphicDesigners = List.of("Laís Mansano", "Doralice de Carvalho");
        List<String> developers = List.of("João Gabriel Carvalho");
        List<String> students = List.of("Antônio Lopes da Cruz", "Marília Gabriela");
        values.add(graphicDesigners);
        values.add(developers);
        values.add(students);

        for (List<String> value : values) {
            for (String s : value) {
                System.out.println(s);
            }
        }

        values.stream().flatMap(Collection::stream).forEach(System.out::println);
    }
}
