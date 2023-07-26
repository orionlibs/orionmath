package io.github.orionlibs.math.algebra.number;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

@TestInstance(Lifecycle.PER_METHOD)
@Execution(ExecutionMode.CONCURRENT)
public class NumTest_value
{
    @Test
    void test_isZero()
    {
        assertFalse(Num.of("123.8520852095820000000000000000000000000000").isZero());
        assertTrue(Num.of("0").isZero());
        assertTrue(Num.of().isZero());
    }


    @Test
    void test_hasPositiveInfiniteValue()
    {
        assertFalse(Num.of("999999999999999999999999999999999999999999999999999999999999999999999999999999.0").hasPositiveInfiniteValue());
        assertTrue(Num.of("999999999999999999999999999999999999999999999999999999999999999999999999999999.1").hasPositiveInfiniteValue());
        assertTrue(Num.of("9999999999999999999999999999999999999999999999999999999999999999999999999999999.0").hasPositiveInfiniteValue());
    }


    @Test
    void test_hasNegativeInfiniteValue()
    {
        assertFalse(Num.of("-999999999999999999999999999999999999999999999999999999999999999999999999999999.0").hasNegativeInfiniteValue());
        assertTrue(Num.of("-999999999999999999999999999999999999999999999999999999999999999999999999999999.1").hasNegativeInfiniteValue());
        assertTrue(Num.of("-9999999999999999999999999999999999999999999999999999999999999999999999999999999.0").hasNegativeInfiniteValue());
    }


    @Test
    void test_hasInfiniteValue()
    {
        assertFalse(Num.of("-999999999999999999999999999999999999999999999999999999999999999999999999999999.0").hasInfiniteValue());
        assertTrue(Num.of("-999999999999999999999999999999999999999999999999999999999999999999999999999999.1").hasInfiniteValue());
        assertTrue(Num.of("-9999999999999999999999999999999999999999999999999999999999999999999999999999999.0").hasInfiniteValue());
        assertFalse(Num.of("999999999999999999999999999999999999999999999999999999999999999999999999999999.0").hasInfiniteValue());
        assertTrue(Num.of("999999999999999999999999999999999999999999999999999999999999999999999999999999.1").hasInfiniteValue());
        assertTrue(Num.of("9999999999999999999999999999999999999999999999999999999999999999999999999999999.0").hasInfiniteValue());
    }
}
