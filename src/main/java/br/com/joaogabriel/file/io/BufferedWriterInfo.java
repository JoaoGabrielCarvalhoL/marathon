package br.com.joaogabriel.file.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterInfo {
    public static void main(String[] args) {
        File file = new File("files/text.txt");
        try (FileWriter fileWriter = new FileWriter(file);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            /**
             * BufferedWriter is optimized to write in a file.
             * */
            bufferedWriter.write("'Breaking Bad' tem 62 capítulos: é o número do elemento químico Samário, na tabela periódica. O isótopo é usado para tratar o câncer de pulmão.");
            bufferedWriter.newLine();
            bufferedWriter.write("Curiosamente, o último capítulo da série não se chama Samário, mas FeLiNa: Fe (Ferro), Li (Lítio) e Na (Sódio), elementos presentes no sangue, na fabricação da metanfetamina e nas lágrimas. ");
            bufferedWriter.write("Basicamente, o último capítulo pode ser traduzido como sangue, meta e lágrimas.");
            bufferedWriter.newLine();
            bufferedWriter.flush();
        } catch (IOException ioException) {
            throw new RuntimeException();
        }
    }
}
