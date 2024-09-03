package br.com.joaogabriel.wrappers;

/**
 * They are objects that encapsulate primitive types.
 * Default values is null.
 * */
public class Wrappers {

    /**
     * AutoBoxing
     * */
    Byte byteWrapper = 1;
    Short shortWrapper = 1;
    Integer integerWrapper = 1;
    Long longWrapper = 1L;
    Float floatWrapper = 1F;
    Double doubleWrapper = 1D;
    Character characterWrapper = 'J';
    Boolean booleanWrapper = false;

    /**
     * Unboxing
     * */
    int integerPrimitive = integerWrapper;
}
