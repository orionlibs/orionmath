package io.github.orionlibs.math.algebra.number;

import io.github.orionlibs.math.core.Pair;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public interface PrecisionNumber
{
    int DEFAULT_PRECISION = 15;
    BigDecimal SystemEPS = initialiseAndGetDefaultTolerance();
    BigDecimal DefaultEPS = getEPS(DEFAULT_PRECISION);


    private static BigDecimal initialiseAndGetDefaultTolerance()
    {
        double dTemp = 0.5;
        while(1 + dTemp > 1)
        {
            dTemp /= 2;
        }
        return new BigDecimal(Double.toString(dTemp));
    }


    private static BigDecimal getEPS(int precision)
    {
        return BigDecimal.valueOf(5).movePointLeft(precision);
    }


    static boolean isValid(int precision)
    {
        return precision > 0;
    }


    static int getValidPrecision(int precision)
    {
        if(isValid(precision))
        {
            return precision;
        }
        else
        {
            return DEFAULT_PRECISION;
        }
    }


    default Pair<BigDecimal, BigDecimal> applyPrecision(int precision, BigDecimal real, BigDecimal imaginary)
    {
        precision = getValidPrecision(precision);
        real = real.setScale(precision, RoundingMode.HALF_EVEN);
        real = new BigDecimal(real.toPlainString(), MathContext.UNLIMITED).setScale(precision + 1).stripTrailingZeros();
        imaginary = imaginary.setScale(precision, RoundingMode.HALF_EVEN);
        imaginary = new BigDecimal(imaginary.toPlainString(), MathContext.UNLIMITED).setScale(precision + 1).stripTrailingZeros();
        return Pair.<BigDecimal, BigDecimal>of(real, imaginary);
    }
}