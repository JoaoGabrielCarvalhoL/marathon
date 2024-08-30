package br.com.joaogabriel.poo.inheritance;

public class Person {
    private String name;
    private String document;
    private Address address;

    public Person() {}

    public Person(String name, String document, Address address) {
        this.name = name;
        this.document = document;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void print() {
        System.out.println(String.format("Name: %s\nDocument: %s\nAddress: %s",
                this.name, this.document, this.address.getPublicPlace()));
    }
}
