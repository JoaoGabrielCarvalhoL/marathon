package br.com.joaogabriel.basic.arrays;

public class Matrices {

    //Arrays multidimensional
    //Array of Arrays.
    public static void main(String[] args) {
        //i columns and j is a lines
        int[][] matrices = new int[4][4];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                matrices[i][j] = j;
            }
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(matrices[i][j]);
            }
            System.out.println();
        }

        for (int[] base : matrices) {
            for(int values : base) {
                System.out.print(values);
            }
            System.out.println();
        }

        System.out.println("------------");
        int[][] arrayBase = new int[3][];
        for(int i = 0; i < 3; i++) {
            arrayBase[i] = new int[i+1];
        }

        for (int i = 0; i < arrayBase.length; i++) {
            for (int j = 0; j < arrayBase[i].length; j++) {
                matrices[i][j] = j + i;
            }
        }

        for (int[] base : arrayBase) {
            for(int values : base) {
                System.out.print(values);
            }
            System.out.println();
        }
    }
}

