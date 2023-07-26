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
public class NumTest_digits
{
    @Test
    void test_getNumberOfDecimalDigitsOfRealValue()
    {
        assertEquals(12, Num.of("123.8520852095820000000000000000000000000000").getNumberOfDecimalDigitsOfRealValue());
        assertEquals(12, Num.of("-123.8520852095820000000000000000000000000000").getNumberOfDecimalDigitsOfRealValue());
        assertEquals(0, Num.ofMin().getNumberOfDecimalDigitsOfRealValue());
        assertEquals(0, Num.ofMax().getNumberOfDecimalDigitsOfRealValue());
    }


    @Test
    void test_getNumberOfDecimalDigitsOfImaginaryValue()
    {
        assertEquals(12, Num.of("10", "123.8520852095820000000000000000000000000000").getNumberOfDecimalDigitsOfImaginaryValue());
        assertEquals(12, Num.of("10", "-123.8520852095820000000000000000000000000000").getNumberOfDecimalDigitsOfImaginaryValue());
    }


    @Test
    void test_hasRealValueDecimalDigits()
    {
        assertTrue(Num.of("123.852085209582").hasRealValueDecimalDigits());
        assertFalse(Num.of("-123.0").hasRealValueDecimalDigits());
        assertFalse(Num.of("123.").hasRealValueDecimalDigits());
        assertFalse(Num.of("-123").hasRealValueDecimalDigits());
    }


    @Test
    void test_hasImaginaryValueDecimalDigits()
    {
        assertTrue(Num.of("10", "123.852085209582").hasImaginaryValueDecimalDigits());
        assertFalse(Num.of("10", "-123.0").hasImaginaryValueDecimalDigits());
        assertFalse(Num.of("10", "123.").hasImaginaryValueDecimalDigits());
        assertFalse(Num.of("10", "-123").hasImaginaryValueDecimalDigits());
    }


    @Test
    void test_reverseDigits()
    {
        assertEquals("285902580258.321", Num.of("123.852085209582").reverseDigits().print());
        assertEquals("-285902580258.321", Num.of("-123.852085209582").reverseDigits().print());
        assertEquals("285902580258.321+285902580258.321i", Num.of("123.852085209582", "123.852085209582").reverseDigits().print());
        assertEquals("-285902580258.321-285902580258.321i", Num.of("-123.852085209582", "-123.852085209582").reverseDigits().print());
        assertEquals("-321", Num.of("-123.0").reverseDigits().print());
        assertEquals("321", Num.of("123.").reverseDigits().print());
        assertEquals("-321", Num.of("-123").reverseDigits().print());
    }


    @Test
    void test_getSumOfDigits()
    {
        assertEquals(60, Num.of("123.852085209582").getSumOfDigits());
        assertEquals(60, Num.of("-123.852085209582").getSumOfDigits());
        assertEquals(60, Num.of("123.852085209582", "123.852085209582").getSumOfDigits());
        assertEquals(60, Num.of("-123.852085209582", "-123.852085209582").getSumOfDigits());
        assertEquals(6, Num.of("-123.0").getSumOfDigits());
        assertEquals(6, Num.of("123.").getSumOfDigits());
        assertEquals(6, Num.of("-123").getSumOfDigits());
    }


    @Test
    void test_getNumberOfDecimalDigits()
    {
        assertEquals(12, Num.of("123.852085209582").getNumberOfDecimalDigitsOfRealValue());
        assertEquals(12, Num.of("-123.852085209582").getNumberOfDecimalDigitsOfRealValue());
        assertEquals(12, Num.of("123.852085209582", "123.852085209582").getNumberOfDecimalDigitsOfRealValue());
        assertEquals(12, Num.of("-123.852085209582", "-123.852085209582").getNumberOfDecimalDigitsOfRealValue());
        assertEquals(0, Num.of("-123.0").getNumberOfDecimalDigitsOfRealValue());
        assertEquals(0, Num.of("123.").getNumberOfDecimalDigitsOfRealValue());
        assertEquals(0, Num.of("-123").getNumberOfDecimalDigitsOfRealValue());
    }


    @Test
    void test_trimZeroes()
    {
        assertEquals("123.852085209582", Num.of("123.8520852095820000000000000000000000000000").trimZeroes().print());
        assertEquals("123.852085209582", Num.of("123.852085209582").trimZeroes().print());
        assertEquals("-123.852085209582", Num.of("-123.8520852095820000000000000000000000000000").trimZeroes().print());
        assertEquals("-123.852085209582", Num.of("-123.852085209582").trimZeroes().print());
    }
}
