package br.com.joaogabriel.parameterizing.behaviors;

import br.com.joaogabriel.parameterizing.behaviors.model.Car;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ParameterizingBehaviorsInfo {
    List<Car> cars = new ArrayList<>(List.of(new Car("green", 2011),
            new Car("black", 1998), new Car("red", 2019)));
    public static void main(String[] args) {
        ParameterizingBehaviorsInfo parameterizingBehaviorsInfo = new ParameterizingBehaviorsInfo();
        List<Car> result = parameterizingBehaviorsInfo.filterByColor("green", parameterizingBehaviorsInfo.cars);
        result.forEach(System.out::println);

    }

    private <T extends Car> List<T> filterByColor(String color, List<T> data) {
        return data.stream().filter(element ->
            element.getColor().equals(color) && element.getYear() < LocalDate.now().getYear()).toList();
    }
}
