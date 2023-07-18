package io.github.orionlibs.math.algebra.number;

import io.github.orionlibs.math.core.exception.MathException;

public class InvalidNumberException extends MathException
{
    private static final String DefaultErrorMessage = "Invalid number.";


    public InvalidNumberException()
    {
        super(DefaultErrorMessage);
    }


    public InvalidNumberException(String message)
    {
        super(message);
    }


    public InvalidNumberException(String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments));
    }


    public InvalidNumberException(Throwable cause, String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments), cause);
    }


    public InvalidNumberException(Throwable cause)
    {
        super(cause, DefaultErrorMessage);
    }
}
