package io.github.orionlibs.math.algebra.number;

import java.math.BigDecimal;

public interface NumberPrinter
{
    default String printRealValue(BigDecimal x)
    {
        return x.toPlainString();
    }


    default String printImaginaryValue(BigDecimal y)
    {
        return y.toPlainString();
    }


    default String print(BigDecimal x, BigDecimal y)
    {
        int realValueExists = BigDecimal.ZERO.compareTo(x);
        int imaginaryValueExists = BigDecimal.ZERO.compareTo(y);
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
            return printRealValue(x);
        }
    }
}