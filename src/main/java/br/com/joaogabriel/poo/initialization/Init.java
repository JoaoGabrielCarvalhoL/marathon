package br.com.joaogabriel.poo.initialization;

public class Init {

    private String name;
    private int[] numbers;

    {
        //Initializer
        System.out.println("Initializer");
        this.numbers = new int[100];
    }

    public Init() {
        this.numbers = new int[100];
        for (int i = 0; i < 100; i++) {
            this.numbers[i] = i + 1;
        }

        for(int num : numbers) {
            System.out.print(num + " ");
        }
    }

    public Init(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int[] getNumbers() {
        return numbers;
    }
}
