package io.github.orionlibs.math.algebra.number;

import java.math.BigDecimal;

public abstract class ANum implements NumberPrinter//Cloneable, Comparable<ANumb>
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


    protected ANum(boolean isNaN)
    {
        if(isNaN)
        {
            setRealValueAsNull();
            setImaginaryValueAsNull();
        }
    }


    public void setRealValueAsNull()
    {
        this.realValue = null;
    }


    public void setImaginaryValueAsNull()
    {
        this.imaginaryValue = null;
    }


    public String printRealValue()
    {
        return NumberPrinter.super.printRealValue(realValue);
    }


    public String printImaginaryValue()
    {
        return NumberPrinter.super.printImaginaryValue(imaginaryValue);
    }


    public String print()
    {
        return NumberPrinter.super.print(realValue, imaginaryValue);
    }


    @Override
    public String toString()
    {
        return print();
    }
}