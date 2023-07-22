package io.github.orionlibs.math.algebra.number;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.math.BigInteger;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

@TestInstance(Lifecycle.PER_METHOD)
@Execution(ExecutionMode.CONCURRENT)
public class NumTest_construction
{
    @Test
    void test_emptyConstructor() throws Exception
    {
        assertEquals("0", Num.of().print());
        assertEquals("0", Num.of().printRealValue());
        assertEquals("+0", Num.of().printImaginaryValue());
    }


    @Test
    void test_constructorForNaN() throws Exception
    {
        //not NaN
        assertEquals("0", Num.of(false).print());
        assertEquals("0", Num.of(false).printRealValue());
        assertEquals("+0", Num.of(false).printImaginaryValue());
        //NaN
        assertEquals("NaN", Num.of(true).print());
        assertEquals("NaN", Num.of(true).printRealValue());
        assertEquals("NaN", Num.of(true).printImaginaryValue());
        assertEquals("NaN", Num.ofNaN().print());
        assertEquals("NaN", Num.ofNaN().printRealValue());
        assertEquals("NaN", Num.ofNaN().printImaginaryValue());
    }


    @Test
    void test_constructorForRealNumber_usingNumberObjects() throws Exception
    {
        assertEquals("1", Num.of(1).print());
        Num num = Num.of(-1);
        assertEquals("-1", num.printRealValue());
        assertEquals("+0", num.printImaginaryValue());
        assertEquals("1234.56789", Num.of(1234.56789d).print());
        assertEquals("-1234.56789", Num.of(-1234.56789d).print());
        assertEquals("1234.567890123457", Num.of(1234.567890123456789d).print());
        assertEquals("-1234567890123.5679", Num.of(-1234567890123.567890123456789d).print());
        assertEquals("12345678901234567890123456789", Num.of(new BigInteger("12345678901234567890123456789")).print());
        assertEquals("-12345678901234567890123456789", Num.of(new BigInteger("-12345678901234567890123456789")).print());
        assertEquals("12345678901234567890123456789", Num.of(new BigDecimal("12345678901234567890123456789")).print());
        assertEquals("-12345678901234567890123456789", Num.of(new BigDecimal("-12345678901234567890123456789")).print());
        assertEquals("12345678901234567890123456789.98765432109876543210987654321", Num.of(new BigDecimal("12345678901234567890123456789.98765432109876543210987654321")).print());
        assertEquals("-12345678901234567890123456789.98765432109876543210987654321", Num.of(new BigDecimal("-12345678901234567890123456789.98765432109876543210987654321")).print());
    }


    @Test
    void test_constructorForRealNumber_usingStrings() throws Exception
    {
        assertEquals("1", Num.of("1").print());
        Num num = Num.of("-1");
        assertEquals("-1", num.printRealValue());
        assertEquals("+0", num.printImaginaryValue());
        assertEquals("1234.56789", Num.of("1234.56789").print());
        assertEquals("-1234.56789", Num.of("-1234.56789").print());
        assertEquals("1234.567890123456789", Num.of("1234.567890123456789").print());
        assertEquals("-1234567890123.567890123456789", Num.of("-1234567890123.567890123456789").print());
        assertEquals("12345678901234567890123456789", Num.of("12345678901234567890123456789").print());
        assertEquals("-12345678901234567890123456789", Num.of("-12345678901234567890123456789").print());
        assertEquals("12345678901234567890123456789.98765432109876543210987654321", Num.of("12345678901234567890123456789.98765432109876543210987654321").print());
        assertEquals("-12345678901234567890123456789.98765432109876543210987654321", Num.of("-12345678901234567890123456789.98765432109876543210987654321").print());
    }


    @Test
    void test_constructorForComplexNumber_usingNumberObjects() throws Exception
    {
        assertEquals("1", Num.of(1, 0).print());
        Num num = Num.of(-1, 0);
        assertEquals("-1", num.printRealValue());
        assertEquals("+0", num.printImaginaryValue());
        assertEquals("1234.56789+1234.56789i", Num.of(1234.56789d, 1234.56789d).print());
        assertEquals("-1234.56789-1234.56789i", Num.of(-1234.56789d, -1234.56789d).print());
        assertEquals("1234.567890123457+1234.567890123457i", Num.of(1234.567890123456789d, 1234.567890123456789d).print());
        assertEquals("-1234567890123.5679-1234567890123.5679i", Num.of(-1234567890123.567890123456789d, -1234567890123.567890123456789d).print());
        assertEquals("12345678901234567890123456789+12345678901234567890123456789i", Num.of(new BigInteger("12345678901234567890123456789"), new BigInteger("12345678901234567890123456789")).print());
        assertEquals("-12345678901234567890123456789-12345678901234567890123456789i", Num.of(new BigInteger("-12345678901234567890123456789"), new BigInteger("-12345678901234567890123456789")).print());
        assertEquals("12345678901234567890123456789+12345678901234567890123456789i", Num.of(new BigDecimal("12345678901234567890123456789"), new BigDecimal("12345678901234567890123456789")).print());
        assertEquals("-12345678901234567890123456789-12345678901234567890123456789i", Num.of(new BigDecimal("-12345678901234567890123456789"), new BigDecimal("-12345678901234567890123456789")).print());
        assertEquals("12345678901234567890123456789.98765432109876543210987654321+12345678901234567890123456789.98765432109876543210987654321i",
                        Num.of(new BigDecimal("12345678901234567890123456789.98765432109876543210987654321"), new BigDecimal("12345678901234567890123456789.98765432109876543210987654321")).print());
        assertEquals("-12345678901234567890123456789.98765432109876543210987654321-12345678901234567890123456789.98765432109876543210987654321i",
                        Num.of(new BigDecimal("-12345678901234567890123456789.98765432109876543210987654321"), new BigDecimal("-12345678901234567890123456789.98765432109876543210987654321")).print());
    }


    @Test
    void test_constructorForComplexNumber_usingStrings() throws Exception
    {
        assertEquals("1", Num.of("1", "0").print());
        Num num = Num.of("-1", "0");
        assertEquals("-1", num.printRealValue());
        assertEquals("+0", num.printImaginaryValue());
        assertEquals("1234.56789+1234.56789i", Num.of("1234.56789", "1234.56789").print());
        assertEquals("-1234.56789-1234.56789i", Num.of("-1234.56789", "-1234.56789").print());
        assertEquals("1234.567890123456789+1234.567890123456789i", Num.of("1234.567890123456789", "1234.567890123456789").print());
        assertEquals("-1234567890123.567890123456789-1234567890123.567890123456789i", Num.of("-1234567890123.567890123456789", "-1234567890123.567890123456789").print());
        assertEquals("12345678901234567890123456789+12345678901234567890123456789i", Num.of("12345678901234567890123456789", "12345678901234567890123456789").print());
        assertEquals("-12345678901234567890123456789-12345678901234567890123456789i", Num.of("-12345678901234567890123456789", "-12345678901234567890123456789").print());
        assertEquals("12345678901234567890123456789.98765432109876543210987654321+12345678901234567890123456789.98765432109876543210987654321i",
                        Num.of("12345678901234567890123456789.98765432109876543210987654321", "12345678901234567890123456789.98765432109876543210987654321").print());
        assertEquals("-12345678901234567890123456789.98765432109876543210987654321-12345678901234567890123456789.98765432109876543210987654321i",
                        Num.of("-12345678901234567890123456789.98765432109876543210987654321", "-12345678901234567890123456789.98765432109876543210987654321").print());
    }


    @Test
    void test_constructorForMinimumNumber() throws Exception
    {
        Num num = Num.ofMin();
        assertEquals("-999999999999999999999999999999999999999999999999999999999999999999999999999999", num.printRealValue());
        assertEquals("+0", num.printImaginaryValue());
    }


    @Test
    void test_constructorForMaximumNumber() throws Exception
    {
        Num num = Num.ofMax();
        assertEquals("999999999999999999999999999999999999999999999999999999999999999999999999999999", num.printRealValue());
        assertEquals("+0", num.printImaginaryValue());
    }
}
