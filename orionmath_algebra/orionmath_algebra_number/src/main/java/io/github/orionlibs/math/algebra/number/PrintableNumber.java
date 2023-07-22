package io.github.orionlibs.math.algebra.number;

import io.github.orionlibs.math.core.OrionPrinter;
import java.math.BigDecimal;

public interface PrintableNumber extends OrionPrinter
{
    default String printRealValue(BigDecimal x)
    {
        return OrionPrinter.super.print(x);
    }


    default String printImaginaryValue(BigDecimal y)
    {
        String printed = OrionPrinter.super.print(y);
        if("NaN".equals(printed))
        {
            return printed;
        }
        else
        {
            return printed.startsWith("-") ? printed : "+" + printed;
        }
    }


    default String print(BigDecimal realValue, BigDecimal imaginaryValue)
    {
        boolean xExists = realValue != null;
        boolean yExists = imaginaryValue != null && BigDecimal.ZERO.compareTo(imaginaryValue) != 0;
        if(yExists)
        {
            return printComplexNumber(realValue, imaginaryValue);
        }
        else
        {
            return xExists ? printRealValue(realValue) : "NaN";
        }
    }


    private String printComplexNumber(BigDecimal realValue, BigDecimal imaginaryValue)
    {
        boolean xExists = realValue != null;
        int xComparisonValue = xExists ? BigDecimal.ZERO.compareTo(realValue) : 0;
        if(xComparisonValue != 0)
        {
            return printRealValue(realValue) + printImaginaryValue(imaginaryValue) + "i";
        }
        else
        {
            return printImaginaryValue(imaginaryValue) + "i";
        }
    }
}