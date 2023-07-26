package io.github.orionlibs.math.core;

import java.util.List;

public interface Tuple
{
    Object get(int index);


    Object[] getAsArray();


    List<Object> getAsList();


    boolean isEmpty();
}