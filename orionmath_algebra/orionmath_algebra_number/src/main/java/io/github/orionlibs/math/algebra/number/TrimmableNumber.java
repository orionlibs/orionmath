package io.github.orionlibs.math.algebra.number;

import java.math.BigDecimal;

public interface TrimmableNumber
{
    default ANum trimZeroes(BigDecimal real, BigDecimal imaginary)
    {
        NumberRules.areNotNull(real, imaginary);
        BigDecimal realValue = real.stripTrailingZeros();
        BigDecimal imaginaryValue = imaginary.stripTrailingZeros();
        return Num.of(realValue, imaginaryValue);
    }
}