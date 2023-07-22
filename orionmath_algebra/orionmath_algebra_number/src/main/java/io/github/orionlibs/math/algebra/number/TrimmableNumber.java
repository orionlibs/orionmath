package io.github.orionlibs.math.algebra.number;

import java.math.BigDecimal;

public interface TrimmableNumber
{
    default ANum trimZeroes(ANum x)
    {
        NumberRules.isNotNull(x);
        BigDecimal realValue = x.getReal().stripTrailingZeros();
        BigDecimal imaginaryValue = x.getImaginary().stripTrailingZeros();
        return Num.of(realValue, imaginaryValue);
    }
}