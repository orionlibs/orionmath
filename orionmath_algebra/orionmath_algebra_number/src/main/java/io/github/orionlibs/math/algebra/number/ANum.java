package io.github.orionlibs.math.algebra.number;

import java.math.BigDecimal;

public abstract class ANum implements PrintableNumber//Cloneable, Comparable<ANumb>
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
        return PrintableNumber.super.printRealValue(realValue);
    }


    public String printImaginaryValue()
    {
        return PrintableNumber.super.printImaginaryValue(imaginaryValue);
    }


    public String print()
    {
        return PrintableNumber.super.print(realValue, imaginaryValue);
    }


    @Override
    public String toString()
    {
        return print();
    }
}