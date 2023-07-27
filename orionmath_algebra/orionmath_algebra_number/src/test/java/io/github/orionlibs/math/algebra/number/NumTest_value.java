package io.github.orionlibs.math.algebra.number;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
    void test_isNotZero()
    {
        assertTrue(Num.of("123.8520852095820000000000000000000000000000").isNotZero());
        assertFalse(Num.of("0").isNotZero());
        assertFalse(Num.of().isNotZero());
    }


    @Test
    void test_isOne()
    {
        assertFalse(Num.of("1.000000000000000000000000000000000000000000000000000000001").isOne());
        assertTrue(Num.of("1").isOne());
    }


    @Test
    void test_isNotOne()
    {
        assertTrue(Num.of("1.000000000000000000000000000000000000000000000000000000001").isNotOne());
        assertFalse(Num.of("1").isNotOne());
    }


    @Test
    void test_isMinusOne()
    {
        assertFalse(Num.of("-1.000000000000000000000000000000000000000000000000000000001").isMinusOne());
        assertTrue(Num.of("-1").isMinusOne());
    }


    @Test
    void test_isNotMinusOne()
    {
        assertTrue(Num.of("-1.000000000000000000000000000000000000000000000000000000001").isNotMinusOne());
        assertFalse(Num.of("-1").isNotMinusOne());
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


    @Test
    void test_isPositive()
    {
        assertFalse(Num.of("-0.000000000000000000000000000000000000000000000000000000001").isPositive());
        assertFalse(Num.of().isPositive());
        assertTrue(Num.of("0.000000000000000000000000000000000000000000000000000000001").isPositive());
    }


    @Test
    void test_isNegative()
    {
        assertTrue(Num.of("-0.000000000000000000000000000000000000000000000000000000001").isNegative());
        assertFalse(Num.of().isNegative());
        assertFalse(Num.of("0.000000000000000000000000000000000000000000000000000000001").isNegative());
    }


    @Test
    void test_isNonPositive()
    {
        assertTrue(Num.of("-0.000000000000000000000000000000000000000000000000000000001").isNonPositive());
        assertTrue(Num.of().isNonPositive());
        assertFalse(Num.of("0.000000000000000000000000000000000000000000000000000000001").isNonPositive());
    }


    @Test
    void test_isNonNegative()
    {
        assertFalse(Num.of("-0.000000000000000000000000000000000000000000000000000000001").isNonNegative());
        assertTrue(Num.of().isNonNegative());
        assertTrue(Num.of("0.000000000000000000000000000000000000000000000000000000001").isNonNegative());
    }


    @Test
    void test_negate()
    {
        assertEquals("-0.0001", Num.of("0.0001").negate().print());
        assertEquals("0.0001", Num.of("-0.0001").negate().print());
        assertEquals("-0.0001-1.234i", Num.of("0.0001", "1.234").negate().print());
        assertEquals("0.0001+1.234i", Num.of("-0.0001", "-1.234").negate().print());
        assertEquals("-0.0001+1.234i", Num.of("0.0001", "-1.234").negate().print());
        assertEquals("0.0001-1.234i", Num.of("-0.0001", "1.234").negate().print());
    }
}
