package br.com.joaogabriel.poo.domain;

import java.time.LocalDate;

public class Professor {

    private String name;
    private String email;
    private String course;
    private LocalDate startedIn;

    public Professor() {}

    public Professor(String name, String email, String course, LocalDate startedIn) {
        this.name = name;
        this.email = email;
        this.course = course;
        this.startedIn = startedIn;
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

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public LocalDate getStartedIn() {
        return startedIn;
    }

    public void setStartedIn(LocalDate startedIn) {
        this.startedIn = startedIn;
    }
}
