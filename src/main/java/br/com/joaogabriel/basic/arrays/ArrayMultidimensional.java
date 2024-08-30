package br.com.joaogabriel.basic.arrays;

public class ArrayMultidimensional {
    public static void main(String[] args) {
        int[][] arr = new int[3][];
        arr[0] = new int[] {1,2,3};
        arr[1] = new int[] {4,5,6};
        arr[2] = new int[] {7,8,9};

        for (int[] values : arr) {
            for (int number: values) {
                System.out.println(number);
            }
            System.out.println("---");
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.printf("I:%d: J:%d: ", i, j);
            }
            System.out.println();
        }
    }
}
