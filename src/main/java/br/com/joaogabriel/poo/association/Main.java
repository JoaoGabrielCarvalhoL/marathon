package br.com.joaogabriel.poo.association;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Player firstPlayer = new Player("Harry");
        Player secondPlayer = new Player("Ron");
        Player thirdPlayer = new Player("Hermione");

        Player[] players = new Player[]{firstPlayer, secondPlayer, thirdPlayer};

        Team team = new Team("gryffindor");
        School school = new School("Hogwarts School of Witchcraft and Wizardry");
        school.setTeams(List.of(team));

        firstPlayer.setTeam(team);
        secondPlayer.setTeam(team);
        thirdPlayer.setTeam(team);

        team.getPlayers().add(firstPlayer);
        team.getPlayers().add(secondPlayer);
        team.getPlayers().add(thirdPlayer);

        Team another = new Team("Slytherin");
        another.setPlayers(Collections.emptyList());

    }

}