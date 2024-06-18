package br.com.joaogabriel.poo.association;

import java.util.Collection;

public class School {

    private String name;
    private Collection<Team> teams;

    public School(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Collection<Team> getTeams() {
        return teams;
    }

    public void setTeams(Collection<Team> teams) {
        this.teams = teams;
    }
}
