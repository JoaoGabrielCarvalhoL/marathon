package br.com.joaogabriel.date.time;

import java.time.Instant;
import java.time.LocalDateTime;

/**
 * Work with nanoseconds
 * Immutable
 * */

public class InstantInfo {
    public static void main(String[] args) {
        Instant now = Instant.now();
        LocalDateTime nowLocalDate = LocalDateTime.now();
        System.out.println(now);
        System.out.println(nowLocalDate);

        System.out.println(now.getEpochSecond());
        System.out.println(now.getNano());
    }
}
