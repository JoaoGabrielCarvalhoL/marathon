package br.com.joaogabriel.basic.arrays;

public class VarArgs {

    //var args must be the last parameter when more parameters exists.
    public void something(int... args) {
        for (int arg : args) {
            System.out.println(arg);
        }
    }
}
