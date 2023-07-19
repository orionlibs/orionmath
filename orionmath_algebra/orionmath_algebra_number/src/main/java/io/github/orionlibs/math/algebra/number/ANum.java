package io.github.orionlibs.math.algebra.number;

import java.math.BigDecimal;

public abstract class ANum// implements Cloneable, Comparable<ANumb>
{
    protected BigDecimal realValue = BigDecimal.ZERO;
    protected BigDecimal imaginaryValue = BigDecimal.ZERO;
    //private int precision = Precision.precision;
    protected boolean isValidNumber;
    protected boolean isFinite;


    protected ANum()
    {
        //this("0", "0");
    }


    /*protected ANum(String realValue, String imaginaryValue)
    {
        new NumberInternalService().saveNumberValues(this, realValue, imaginaryValue);
    }*/


    public String printRealValue()
    {
        return realValue.toPlainString();
    }


    public String printImaginaryValue()
    {
        return imaginaryValue.toPlainString();
    }


    public String print()
    {
        int imaginaryValueToZeroComparison = imaginaryValue.compareTo(BigDecimal.ZERO);
        int realValueToZeroComparison = realValue.compareTo(BigDecimal.ZERO);
        if(imaginaryValueToZeroComparison != 0)
        {
            if(imaginaryValueToZeroComparison > 0)
            {
                if(realValueToZeroComparison != 0)
                {
                    return printRealValue() + printImaginaryValue() + "i";
                }
                else
                {
                    return printImaginaryValue() + "i";
                }
            }
            else
            {
                if(realValueToZeroComparison != 0)
                {
                    return printRealValue() + printImaginaryValue() + "i";
                }
                else
                {
                    return printImaginaryValue() + "i";
                }
            }
        }
        else
        {
            return printRealValue();
        }
        //return NumberService.print(this);
    }


    @Override
    public String toString()
    {
        return print();
    }
}