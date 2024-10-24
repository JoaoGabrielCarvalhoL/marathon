package br.com.joaogabriel.lambda.predicate;

import br.com.joaogabriel.parameterizing.behaviors.model.Car;
import java.util.ArrayList;
import java.util.List;

public class PredicateInfo {
    static List<Car> cars = new ArrayList<>(List.of(new Car("green", 2011),
            new Car("black", 1998), new Car("red", 2019)));

    public static void main(String[] args) {
        List<Car> filtered = filter(cars, car -> car.getColor().equals("green"));
        filtered.forEach(System.out::println);
    }

    public static <T extends Car> List<T> filter(List<T> data, Predicate<T> predicate) {
        return data.stream().filter(predicate::test).toList();
    }
}
