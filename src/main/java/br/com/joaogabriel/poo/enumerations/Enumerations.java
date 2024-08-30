package br.com.joaogabriel.poo.enumerations;

import java.util.UUID;

public enum Enumerations {
    LEGAL_PERSON(UUID.randomUUID(), "Legal Person") {
        @Override
        public double discount(double value) {
            return value * 0.10;
        }
    },
    NATURAL_PERSON(UUID.randomUUID(), "Natural Person") {
        @Override
        public double discount(double value) {
            return value * 0.05;
        }
    };

    private final UUID id; //Always after enumerations values.
    private final String description;

    private Enumerations(UUID id, String description) {
        this.id = id;
        this.description = description;
    }

    public abstract double discount(double value);

    public Enumerations getByDescription(String description) {
        for (Enumerations value : values()) {
            if (value.description.equals(description)) {
                return value;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Type: " + description + ". Id: " + id;
    }
}
