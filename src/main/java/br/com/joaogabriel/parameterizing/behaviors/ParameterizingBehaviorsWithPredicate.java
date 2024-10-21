package br.com.joaogabriel.parameterizing.behaviors;

import br.com.joaogabriel.parameterizing.behaviors.model.Car;
import br.com.joaogabriel.parameterizing.behaviors.predicate.PredicateFilter;

import java.util.ArrayList;
import java.util.List;

public class ParameterizingBehaviorsWithPredicate {
    List<Car> cars = new ArrayList<>(List.of(new Car("green", 2011),
            new Car("black", 1998), new Car("red", 2019)));

    public static void main(String[] args) {
        ParameterizingBehaviorsWithPredicate parameterizingBehaviorsWithPredicate = new ParameterizingBehaviorsWithPredicate();
        List<Car> filtered = parameterizingBehaviorsWithPredicate.filter(parameterizingBehaviorsWithPredicate.cars, new PredicateFilter<Car>() {

            @Override
            public boolean filter(Car car) {
                return car.getColor().equals("green");
            }
        });
        filtered.forEach(System.out::println);
    }

    public <T extends Car> List<T> filter(List<T> data, PredicateFilter<T> predicate) {
        return data.stream().filter(predicate::filter).toList();
    }
}
