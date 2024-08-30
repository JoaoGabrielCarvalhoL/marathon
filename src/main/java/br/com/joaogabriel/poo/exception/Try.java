package br.com.joaogabriel.poo.exception;

import java.io.*;

public class Try {

    public void exampleNormalTry() {
        try {
            File file = new File("files/test.txt");
            boolean newFile = file.createNewFile();
            if (newFile) {
                System.out.println("Works!");
                BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                writer.append("Hello");
                writer.close();
            }

        } catch (IOException exception) {
            throw new RuntimeException();
            /**
             * More catch's() if you need.
             * Obs: Priority exception more specific to more generic. Polymorphism rule.*/
        } finally {
            System.out.println("Ending...");
        }
    }

    public void exampleTryWithResources() {
        /**
         * To use this try, a class to be instantiated must implement Closable or AutoClosable
         * */
        try(BufferedReader reader = new BufferedReader(new FileReader("files/test.txt"))) {
            String line = reader.readLine();
            while(line != null) {
                System.out.println(line);
                line = reader.readLine();
            }

        } catch (IOException exception) {
            throw new RuntimeException("Something is going wrong here...");
        }

    }

    public static void main(String[] args) {
        Try examples = new Try();
        examples.exampleNormalTry();
        examples.exampleTryWithResources();

    }
}
