package br.com.joaogabriel.file.nio;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;

public class PathMatcherInfo {
    public static void main(String[] args) {
        Path firstPath = Paths.get("nio/nio.txt");
        Path secondPath = Paths.get("nio/nio.img");
        Path thirdPath = Paths.get("nio/nio.cpp");

        matches(firstPath, "glob:**.txt");
        matches(secondPath, "glob:**/*.{txt,img,cpp}");
        matches(thirdPath, "glob:**/*.???");

    }

    private static void matches(Path path, String glob) {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher(glob);
        System.out.println("Glob: " + glob + "\nMatcher: " + matcher.matches(path));
    }
}
