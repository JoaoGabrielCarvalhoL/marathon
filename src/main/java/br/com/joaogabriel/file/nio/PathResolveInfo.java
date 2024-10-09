package br.com.joaogabriel.file.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathResolveInfo {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("\\\\wsl.localhost\\Ubuntu-20.04\\home\\joao\\test.txt");
        Path normalize = path.normalize();
        Files.createFile(normalize);

        //Another example
        Path relativeHome = Paths.get("home");
        Path homeDirectory = Files.createDirectories(relativeHome);

        Path absolutePath = Paths.get("D:\\NIO-Files");
        Path absoluteDirectory = Files.createDirectories(absolutePath);

        System.out.println(homeDirectory.resolve(absolutePath));
        System.out.println(homeDirectory.resolve(relativeHome));

        System.out.println(absoluteDirectory.resolve(absolutePath));
        System.out.println(absoluteDirectory.resolve(relativeHome));

        /**
         * Used to resolve the given path against this path. This method will go to connect both paths.
         * If this path is “C/temp” and passed path is “drive/newFile” then this method will add a passed path at the end of this path and use “/” as a separator.
         * So a resolved path will be “C/temp/drive/newFile”.
         * If the other parameter is an absolute path, then this method trivially returns other.
         * If other is an empty path, then this method trivially returns this path. Otherwise, this method considers this path to be a directory and resolves the given path against this path.
         * In the simplest case, the given path does not have a root component, in which case this method joins the given path to this path and returns a resulting path that ends with the given path.
         * Where the given path has a root component, then the resolution is highly implementation-dependent and therefore unspecified.
         * */


        



    }
}
