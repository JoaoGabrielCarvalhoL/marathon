package br.com.joaogabriel.generics.service;

import br.com.joaogabriel.generics.model.Car;

import java.util.ArrayList;
import java.util.List;

public class ProfitableCarService {

    private List<Car> availableCars = new ArrayList<>(List.of(new Car("Virtus"), new Car("SpaceFox")));

    public Car findAvailableCars() {
        System.out.println("Getting available cars: " + this.availableCars);
        Car removed = this.availableCars.remove(0);
        System.out.println("Car: " + removed);
        return removed;
    }

    public void devolutionOfCarRetrieved(Car car) {
        this.availableCars.add(car);
        System.out.println("Done");
    }
}
