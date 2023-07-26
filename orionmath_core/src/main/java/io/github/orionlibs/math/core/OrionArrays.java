package io.github.orionlibs.math.core;

import io.github.orionlibs.math.core.exception.Assert;
import java.util.stream.IntStream;

public class OrionArrays
{
    public static <T> Object[] getAsArrayOfObjects(T[] array)
    {
        Assert.notEmpty(array, "The input array cannot be null or empty.");
        Object[] newArray = new Object[array.length];
        IntStream.range(0, array.length).forEach(i -> newArray[i] = (Object)array[i]);
        return newArray;
    }
}