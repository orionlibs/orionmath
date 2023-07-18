package io.github.orionlibs.orionmath;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

@TestInstance(Lifecycle.PER_CLASS)
@Execution(ExecutionMode.CONCURRENT)
public class NewClassTest
{
    @BeforeEach
    void setUp()
    {
    }


    @AfterEach
    public void teardown()
    {
    }


    @Test
    void test_method1() throws Exception
    {
        assertTrue(true);
        /*ConfigurationService.updateProp("orionlibs.prop", "false");
        mockMvc.perform(get("/")).andExpect(status().isOk());
        assertTrue(listLogHandler.getLogRecords().stream()
                        .anyMatch(record -> record.getMessage().contains("hello world")));
        ConfigurationService.updateProp("orionlibs.prop", "true");*/
    }
}
