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
public class NumTest_type
{
    @Test
    void test_hasIntegerValue()
    {
        assertTrue(Num.of("123").hasIntegerValue());
        assertTrue(Num.of("123", "0.99999999999").hasIntegerValue());
        assertTrue(Num.of("-123").hasIntegerValue());
        assertTrue(Num.of("-123.0").hasIntegerValue());
        assertFalse(Num.of("123.000000000000000000000000001").hasIntegerValue());
        assertFalse(Num.of("-123.000000000000000000000000001").hasIntegerValue());
    }


    @Test
    void test_hasImaginaryValueIntegerValue()
    {
        assertTrue(Num.of("123").hasImaginaryValueIntegerValue());
        assertFalse(Num.of("123", "0.99999999999").hasImaginaryValueIntegerValue());
        assertTrue(Num.of("-123").hasImaginaryValueIntegerValue());
        assertFalse(Num.of("123", "123.000000000000000000000000001").hasImaginaryValueIntegerValue());
    }


    @Test
    void test_hasDecimalValue()
    {
        assertFalse(Num.of("123").hasDecimalValue());
        assertTrue(Num.of("123", "0.99999999999").hasDecimalValue());
        assertFalse(Num.of("-123").hasDecimalValue());
        assertFalse(Num.of("-123.0").hasDecimalValue());
        assertTrue(Num.of("123.000000000000000000000000001").hasDecimalValue());
        assertTrue(Num.of("-123.000000000000000000000000001").hasDecimalValue());
    }


    @Test
    void test_isComplexNumber()
    {
        assertFalse(Num.of("123").isComplexNumber());
        assertTrue(Num.of("123", "0.99999999999").isComplexNumber());
        assertFalse(Num.of("-123").isComplexNumber());
        assertFalse(Num.of("-123.0").isComplexNumber());
        assertFalse(Num.of("123.000000000000000000000000001").isComplexNumber());
        assertFalse(Num.of("-123.000000000000000000000000001").isComplexNumber());
    }


    @Test
    void test_isNaN()
    {
        assertFalse(Num.of("123").isNaN());
        assertFalse(Num.of("123", "0.99999999999").isNaN());
        assertTrue(Num.ofNaN().isNaN());
    }
}
