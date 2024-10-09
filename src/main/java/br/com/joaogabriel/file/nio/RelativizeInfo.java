package br.com.joaogabriel.file.nio;


import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Given a Path, how to get to another Path.
 * */
public class RelativizeInfo {
    public static void main(String[] args) {
        Path absoluteDir = Paths.get("D:\\NIO-Files");
        Path clazz = Paths.get("D:\\NIO-Files\\Class\\HelloWorld.java");

        Path pathToClazz = absoluteDir.relativize(clazz);
        System.out.println(pathToClazz);
    }
}
