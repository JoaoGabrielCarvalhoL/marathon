package br.com.joaogabriel.poo.exception;

public class IntroductionExceptions {
    /**
     *                  Throwable
     *      Error <-                -> Exception: (IO, SQL, MalformedURL e etc.) { Checked }
     *                                 - RuntimeException (NullPointer, NumberFormat, ClassCast, IndexOfBound e etc.) { Unchecked }
     *
     *  Error: Situations that cannot be recovered. Ex.: OutOfMemoryError, StackOverFlowError, VirtualMachineError, Error.
     *      -> Stop the program and resolve the problem and start.
     *
     *  Exception:
     *      - Checked: Child classes of Exception and if not handled, will generate an error at compile time.
     *      - Unchecked: Child classes of RuntimeException are generated or thrown at runtime. Cause: you.
     *
     * */
}
