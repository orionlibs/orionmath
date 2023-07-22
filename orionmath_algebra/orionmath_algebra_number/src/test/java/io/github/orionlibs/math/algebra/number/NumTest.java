package io.github.orionlibs.math.algebra.number;

import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

@TestInstance(Lifecycle.PER_METHOD)
@Execution(ExecutionMode.CONCURRENT)
public class NumTest
{
    /*@Test
    void test_trimZeroes()
    {
        Num num = Num.of("123.8520852095820000000000000000000000000000");
        assertEquals("123.852085209582", num.print());
        assertEquals("123.852085209582", num.printRealValue());
        assertEquals("+0", num.printImaginaryValue());
        num = (Num)num.trimZeroes();
        assertEquals("123.852085209582", num.print());
        assertEquals("123.852085209582", num.printRealValue());
        assertEquals("+0", num.printImaginaryValue());
    }*/
}
