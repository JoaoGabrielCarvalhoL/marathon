package br.com.joaogabriel.poo.staticc;

public class Car {

    private String model;
    private String brand;
    private static double maxVelocity;

    /**
     * Static methods are indicated when this method does not interact with the class instance attributes.
     * */

    {
        /**
         *  1 Allocated memory for the object
         *  2 Initialize attributes with default values. (Ex.: Primitive types = 0, 0.00; References = null)
         *  3 Initialization block
         *  4 Constructors
         */

    }

    static {
        /**
         * 0 When class is be loaded by JVM
         */
    }

    public Car(String model, String brand, double maxVelocity) {
        this.model = model;
        this.brand = brand;
        Car.maxVelocity = maxVelocity;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public static double getMaxVelocity() {
        return maxVelocity;
    }

    public static void setMaxVelocity(double maxVelocity) {
        Car.maxVelocity = maxVelocity;
    }
}
