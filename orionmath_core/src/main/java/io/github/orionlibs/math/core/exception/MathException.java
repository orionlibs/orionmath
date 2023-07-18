package io.github.orionlibs.math.core.exception;

public abstract class MathException extends OrionUncheckedException
{
    private static final String DefaultErrorMessage = "There is a mathematical problem.";


    public MathException()
    {
        super(DefaultErrorMessage);
    }


    public MathException(String message)
    {
        super(message);
    }


    public MathException(String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments));
    }


    public MathException(Throwable cause, String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments), cause);
    }


    public MathException(Throwable cause)
    {
        super(cause, DefaultErrorMessage);
    }
}