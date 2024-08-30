package br.com.joaogabriel.poo.inheritance;

public class Address {
    private String publicPlace;
    private String postalCode;

    public Address() {}

    public Address(String publicPlace, String postalCode) {
        this.publicPlace = publicPlace;
        this.postalCode = postalCode;
    }

    public String getPublicPlace() {
        return publicPlace;
    }

    public void setPublicPlace(String publicPlace) {
        this.publicPlace = publicPlace;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
