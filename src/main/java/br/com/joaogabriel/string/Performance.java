package br.com.joaogabriel.string;

import java.util.Scanner;

public class Performance {

    private String concatStringBuilder(Integer times) {
        if (times <= 0) throw new IllegalArgumentException("Must be greater than 0");
        StringBuilder assistant = new StringBuilder(times);
        for (int i = 0; i < times; i++) {
            assistant.append(i);
        }
        return assistant.toString();
    }

    private String concatString(Integer times) {
        if (times <= 0) throw new IllegalArgumentException("Must be greater than 0");
        String assistant = "";
        for (int i = 0; i < times; i++) {
            assistant += i;
        }
        return assistant;
    }

    public static void main(String[] args) {
        Performance performance = new Performance();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Times: ");
        Integer times = scanner.nextInt();

        stringBuilder(performance, times);
        System.out.println("\n------------------------\n");
        string(performance, times);

    }

    private static void stringBuilder(Performance performance, Integer times) {
        long begin = System.currentTimeMillis();
        String result = performance.concatStringBuilder(times);
        long end = System.currentTimeMillis();
        System.out.println("Result: " + result);
        System.out.printf("StringBuilder - Milliseconds: %d", (end - begin));
    }

    private static void string(Performance performance, Integer times) {
        long begin = System.currentTimeMillis();
        String result = performance.concatString(times);
        long end = System.currentTimeMillis();
        System.out.println("Result: " + result);
        System.out.printf("String - Milliseconds: %d", (end - begin));
    }
}
