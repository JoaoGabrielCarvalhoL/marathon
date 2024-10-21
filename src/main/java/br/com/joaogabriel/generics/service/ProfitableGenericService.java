package br.com.joaogabriel.generics.service;

import java.util.List;

public class ProfitableGenericService<T> {

    private List<T> availables;

    public ProfitableGenericService(List<T> availables) {
        this.availables = availables;
    }

    public T getAvailableResource() {
        System.out.println("Getting...");
        T object = this.availables.remove(0);
        System.out.println("Resource: " + object);
        return object;
    }

    public void devolutionOfResource(T resource) {
        this.availables.add(resource);
        System.out.println("Done");
    }
}
