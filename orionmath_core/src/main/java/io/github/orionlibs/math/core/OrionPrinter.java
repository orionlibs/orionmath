package io.github.orionlibs.math.core;

import java.math.BigDecimal;

public interface OrionPrinter
{
    static String print(BigDecimal x)
    {
        return x != null ? x.toPlainString() : "NaN";
    }
}