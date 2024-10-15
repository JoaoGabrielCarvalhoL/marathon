package br.com.joaogabriel.collections.model;

import java.util.HashMap;
import java.util.Objects;

public class Smartphone {
    private String serial;
    private String brand;

    public Smartphone() {}

    public Smartphone(String serial, String brand) {
        this.serial = serial;
        this.brand = brand;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * Reflexivo: x.equals(x) tem que ser true para tudo que for diferente de null.
     * Simétrico: Para x e y diferentes de null, se x.equals(y) == true, logo, y.equals(x) == true
     * Transitividade: para x, y, z diferentes de null, se x.equals(y) == true, logo y.equals(z) == true, logo, y.equals(z) == true
     * Consistente: x.equals(x) sempre retorna true se x for diferente de null
     * */

    /**
     * Indicates whether some other object is "equal to" this one.
     * <p>
     * The {@code equals} method implements an equivalence relation
     * on non-null object references:
     * <ul>
     * <li>It is <i>reflexive</i>: for any non-null reference value
     *     {@code x}, {@code x.equals(x)} should return
     *     {@code true}.
     * <li>It is <i>symmetric</i>: for any non-null reference values
     *     {@code x} and {@code y}, {@code x.equals(y)}
     *     should return {@code true} if and only if
     *     {@code y.equals(x)} returns {@code true}.
     * <li>It is <i>transitive</i>: for any non-null reference values
     *     {@code x}, {@code y}, and {@code z}, if
     *     {@code x.equals(y)} returns {@code true} and
     *     {@code y.equals(z)} returns {@code true}, then
     *     {@code x.equals(z)} should return {@code true}.
     * <li>It is <i>consistent</i>: for any non-null reference values
     *     {@code x} and {@code y}, multiple invocations of
     *     {@code x.equals(y)} consistently return {@code true}
     *     or consistently return {@code false}, provided no
     *     information used in {@code equals} comparisons on the
     *     objects is modified.
     * <li>For any non-null reference value {@code x},
     *     {@code x.equals(null)} should return {@code false}.
     * </ul>
     *
     * <p>
     * An equivalence relation partitions the elements it operates on
     * into <i>equivalence classes</i>; all the members of an
     * equivalence class are equal to each other. Members of an
     * equivalence class are substitutable for each other, at least
     * for some purposes.
     *
     * @implSpec
     * The {@code equals} method for class {@code Object} implements
     * the most discriminating possible equivalence relation on objects;
     * that is, for any non-null reference values {@code x} and
     * {@code y}, this method returns {@code true} if and only
     * if {@code x} and {@code y} refer to the same object
     * ({@code x == y} has the value {@code true}).
     *
     * In other words, under the reference equality equivalence
     * relation, each equivalence class only has a single element.
     *
     * @apiNote
     * It is generally necessary to override the {@link #hashCode() hashCode}
     * method whenever this method is overridden, so as to maintain the
     * general contract for the {@code hashCode} method, which states
     * that equal objects must have equal hash codes.
     *
     * @param   o   the reference object with which to compare.
     * @return  {@code true} if this object is the same as the obj
     *          argument; {@code false} otherwise.
     * @see     #hashCode()
     * @see     HashMap
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Smartphone that = (Smartphone) o;
        return Objects.equals(serial, that.serial) && Objects.equals(brand, that.brand);
    }


    /**
     * Returns a hash code value for the object. This method is supported for the benefit of hash tables such as those provided by java. util. HashMap.
     * The general contract of hashCode is:
     * Whenever it is invoked on the same object more than once during an execution of a Java application, the hashCode method must consistently return the same integer, provided no information used in equals comparisons on the object is modified. This integer need not remain consistent from one execution of an application to another execution of the same application.
     * If two objects are equal according to the equals method, then calling the hashCode method on each of the two objects must produce the same integer result.
     * It is not required that if two objects are unequal according to the equals method, then calling the hashCode method on each of the two objects must produce distinct integer results. However, the programmer should be aware that producing distinct integer results for unequal objects may improve the performance of hash tables.
     * Returns:
     * a hash code value for this object.
     * Implementation Requirements:
     * As far as is reasonably practical, the hashCode method defined by class Object returns distinct integers for distinct objects.
     * See Also:
     * equals(Object), System. identityHashCode
     * */
    @Override
    public int hashCode() {
        System.out.println("Hello from equals by collection");
        int result = Objects.hashCode(serial);
        result = 31 * result + Objects.hashCode(brand);
        return result;
    }

    @Override
    public String toString() {
        return "Smartphone{" +
                "serial='" + serial + '\'' +
                ", brand='" + brand + '\'' +
                '}';
    }
}
