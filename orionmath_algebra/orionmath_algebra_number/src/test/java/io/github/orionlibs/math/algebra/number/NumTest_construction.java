package io.github.orionlibs.math.algebra.number;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        assertEquals("0", Num.of().printImaginaryValue());
    }
}
