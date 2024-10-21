package br.com.joaogabriel.generics;

import java.util.List;

public class GenericMethodsInfo {

    private <T> void createArray(T object) {
        List<T> list = List.of(object);
    }

    private <T> List<T> create(T obj) {
        return List.of(obj);
    }
}
