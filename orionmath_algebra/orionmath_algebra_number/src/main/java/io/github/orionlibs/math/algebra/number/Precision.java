package io.github.orionlibs.math.algebra.number;

import java.math.BigDecimal;

public interface Precision
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
}