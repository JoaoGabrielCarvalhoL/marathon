package br.com.joaogabriel.generics.service;

import br.com.joaogabriel.generics.model.Boat;
import br.com.joaogabriel.generics.model.Car;

import java.util.ArrayList;
import java.util.List;

public class ProfitableBoatService {

    private List<Boat> availableCars = new ArrayList<>(List.of(new Boat("Virtus"), new Boat("SpaceFox")));

    public Boat findAvailableBoat() {
        System.out.println("Getting available cars: " + this.availableCars);
        Boat removed = this.availableCars.remove(0);
        System.out.println("Car: " + removed);
        return removed;
    }

    public void devolutionOfBoatRetrieved(Boat boat) {
        this.availableCars.add(boat);
        System.out.println("Done");
    }
}
