package io.github.orionlibs.math.algebra.number;

import java.math.BigDecimal;
import java.math.MathContext;

public abstract class ANum implements PrintableNumber, ValidNumber//Cloneable, Comparable<ANumb>
{
    protected BigDecimal realValue = BigDecimal.ZERO;
    protected BigDecimal imaginaryValue = BigDecimal.ZERO;
    //private int precision = Precision.precision;
    protected boolean isValidNumber;
    protected boolean isFinite;


    protected ANum()
    {
        this.isValidNumber = true;
        //this("0", "0");
    }


    protected ANum(boolean isNaN)
    {
        if(isNaN)
        {
            setRealValueAsNull();
            setImaginaryValueAsNull();
        }
        else
        {
            this.isValidNumber = true;
        }
    }


    protected ANum(Number realValue)
    {
        this.realValue = new BigDecimal(realValue.toString());
        this.isValidNumber = true;
    }


    protected ANum(Number realValue, Number imaginaryValue)
    {
        NumberRules.areNotNull(realValue, imaginaryValue);
        saveNumberValues(realValue.toString(), imaginaryValue.toString());
    }


    protected ANum(String realValue, String imaginaryValue)
    {
        saveNumberValues(realValue, imaginaryValue);
    }


    protected ANum(String realValue)
    {
        saveNumberValues(realValue, "0");
    }


    private void saveNumberValues(String realValue, String imaginaryValue)
    {
        boolean isValidRealNumber = isValid(realValue);
        boolean isValidImaginaryNumber = isValid(imaginaryValue);
        this.isValidNumber = isValidRealNumber && isValidImaginaryNumber;
        if(isValidNumber)
        {
            MathContext mathContext = MathContext.UNLIMITED;
            BigDecimal realValueTemp = new BigDecimal(realValue, mathContext);
            BigDecimal imaginaryValueTemp = new BigDecimal(imaginaryValue, mathContext);
            this.realValue = realValueTemp.stripTrailingZeros();
            //setPrecision(Precision.getValidPrecision(realValueTemp.scale(), imaginaryValueTemp.scale()));
            if(!imaginaryValue.isEmpty())
            {
                this.imaginaryValue = imaginaryValueTemp.stripTrailingZeros();
                //applyPrecision();
            }
            //applyPrecision();
        }
        else
        {
            if(realValue != null)
            {
                throw new InvalidNumberException("The provided value is invalid and cannot create a number out of it.");
            }
            else
            {
                setRealValueAsNull();
                setImaginaryValueAsNull();
            }
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