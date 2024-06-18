package br.com.joaogabriel.poo.constructors;

public class Person {

    private String name;
    private String email;

    private String anotherAttrib;

    public Person() {
        System.out.println("Calling default constructor.");
    }

    public Person(String name, String email) {
        this(); //must be first sentence in constructor.
        this.name = name;
        this.email = email;
        System.out.println("Calling constructor with two arguments");
    }
    public Person(String name, String email, String anotherAttrib) {
        this(name, email);
        this.name = name;
        this.email = email;
        this.anotherAttrib = anotherAttrib;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAnotherAttrib() {
        return anotherAttrib;
    }

    public void setAnotherAttrib(String anotherAttrib) {
        this.anotherAttrib = anotherAttrib;
    }
}
