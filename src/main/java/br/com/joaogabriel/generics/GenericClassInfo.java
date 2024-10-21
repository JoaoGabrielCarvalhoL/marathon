package br.com.joaogabriel.generics;

import br.com.joaogabriel.generics.model.Boat;
import br.com.joaogabriel.generics.model.Car;
import br.com.joaogabriel.generics.service.ProfitableGenericService;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * */

public class GenericClassInfo {

    public static void main(String[] args) {
        List<Boat> availableBoats = new ArrayList<>(List.of(new Boat("Boat 1"), new Boat("Boat 2")));
        List<Car> availableCars = new ArrayList<>(List.of(new Car("Car 1"), new Car("Car 2")));

        ProfitableGenericService<Car> carProfitableGenericService = new ProfitableGenericService<>(availableCars);
        ProfitableGenericService<Boat> boatProfitableBoatService = new ProfitableGenericService<>(availableBoats);

        Car availableResource = carProfitableGenericService.getAvailableResource();
        Boat availableResource1 = boatProfitableBoatService.getAvailableResource();
        carProfitableGenericService.devolutionOfResource(availableResource);
        boatProfitableBoatService.devolutionOfResource(availableResource1);


    }

}
