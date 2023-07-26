package io.github.orionlibs.math.algebra.number;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

@TestInstance(Lifecycle.PER_METHOD)
@Execution(ExecutionMode.CONCURRENT)
public class NumTest_precision
{
    @Test
    void test_applyPrecision()
    {
        Num x1 = Num.of();
        x1.applyPrecision(1);
        assertEquals("0", x1.print());
        Num x2 = Num.of();
        x2.applyPrecision(10);
        assertEquals("0", x2.print());
        Num x3 = Num.of("1.2345");
        x3.applyPrecision(1);
        assertEquals("1.2", x3.print());
        Num x4 = Num.of("1.8745");
        x4.applyPrecision(1);
        assertEquals("1.9", x4.print());
        Num x5 = Num.of("-1.2345678901234567890123456789");
        x5.applyPrecision(10);
        assertEquals("-1.2345678901", x5.print());
        Num x6 = Num.of("-1.2345678901234567890123456789");
        x6.applyPrecision(25);
        assertEquals("-1.2345678901234567890123457", x6.print());
    }
}
