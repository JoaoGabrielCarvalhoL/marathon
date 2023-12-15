package br.com.joaogabriel.basic.arrays;
public class BasicArrays {
    public static void main(String[] args) {
        int[] numbers = new int[10];

        for (int i = 0; i < 10; i++) {
            numbers[i] = i;
        }
        for(int number : numbers) {
            System.out.println(number);
        }
    }
}
