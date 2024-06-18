package br.com.joaogabriel.poo.association;

import java.util.Collection;

public class Team {

    private String name;
    private School school;
    private Collection<Player> players;

    public Team(String name) {
        this.name = name;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Collection<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Collection<Player> players) {
        this.players = players;
    }

    @Override
    public String toString() {
        return "Team: " + getName();
    }
}
