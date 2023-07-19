package io.github.orionlibs.math.algebra.number;

import java.math.BigDecimal;

public interface NumberPrinter
{
    default String printRealValue(BigDecimal x)
    {
        return x != null ? x.toPlainString() : "NaN";
    }


    default String printImaginaryValue(BigDecimal y)
    {
        return y != null ? y.toPlainString() : "NaN";
    }


    default String print(BigDecimal x, BigDecimal y)
    {
        boolean xExists = x != null;
        boolean yExists = y != null;
        int realValueExists = xExists ? BigDecimal.ZERO.compareTo(x) : 0;
        int imaginaryValueExists = yExists ? BigDecimal.ZERO.compareTo(y) : 0;
        if(imaginaryValueExists != 0)
        {
            if(realValueExists != 0)
            {
                return printRealValue(x) + printImaginaryValue(y) + "i";
            }
            else
            {
                return printImaginaryValue(y) + "i";
            }
        }
        else
        {
            return xExists ? printRealValue(x) : "NaN";
        }
    }
}