package br.com.joaogabriel.inner;

/**
 * Class inside a body of method.
 * */
public class LocalClassInfo {

    private String value = "Outer class";

    //Usage?
    public void print() {
        //Must be final
        final String value = "Local class";
        class LocalClass {
            public void printInsideOfClass() {
                System.out.println(LocalClassInfo.this.value + value);
            }
        }
        LocalClass localClass = new LocalClass();
        localClass.printInsideOfClass();
    }

    public static void main(String[] args) {
        LocalClassInfo localClassInfo = new LocalClassInfo();
        localClassInfo.print();
    }
}
