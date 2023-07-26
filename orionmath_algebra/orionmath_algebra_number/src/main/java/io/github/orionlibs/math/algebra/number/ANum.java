package io.github.orionlibs.math.algebra.number;

import static io.github.orionlibs.math.algebra.number.Precision.DEFAULT_PRECISION;

import io.github.orionlibs.math.core.OrionPrinter;
import java.math.BigDecimal;
import java.math.MathContext;

public abstract class ANum//implements Cloneable, Comparable<ANumb>
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


    private boolean isValid(String value)
    {
        NumberRules.isNotNull(value);
        if(value != null && ("NaN".equals(value) || "infinity".contains(value.toLowerCase())))
        {
            return false;
        }
        else
        {
            try
            {
                new BigDecimal(value);
                return true;
            }
            catch(NumberFormatException e)
            {
                //throw new InvalidArgumentException("Canont parse a nonnumeric string.");
                return false;
            }
        }
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


    public int getNumberOfDecimalDigitsOfRealValue()
    {
        NumberRules.isNotNull(realValue);
        return realValue.stripTrailingZeros().scale();
    }


    public int getNumberOfDecimalDigitsOfImaginaryValue()
    {
        NumberRules.isNotNull(imaginaryValue);
        return imaginaryValue.stripTrailingZeros().scale();
    }


    public boolean hasRealValueDecimalDigits()
    {
        return getNumberOfDecimalDigitsOfRealValue() > 0;
    }


    public boolean hasImaginaryValueDecimalDigits()
    {
        return getNumberOfDecimalDigitsOfImaginaryValue() > 0;
    }


    public int getSumOfDigits()
    {
        NumberRules.isNotNull(realValue);
        int sum = 0;
        char[] digits = realValue.toPlainString().toCharArray();
        for(char digit : digits)
        {
            if(digit != '-' && digit != '.')
            {
                sum += Integer.parseInt(Character.toString(digit));
            }
        }
        return sum;
    }


    public boolean hasIntegerValue()
    {
        return getReal().compareTo(new BigDecimal(getReal().toBigInteger())) == 0;
    }


    public boolean hasImaginaryValueIntegerValue()
    {
        return getImaginary().compareTo(new BigDecimal(getImaginary().toBigInteger())) == 0;
    }


    public boolean hasDecimalValue()
    {
        return getReal().compareTo(new BigDecimal(getReal().toBigInteger())) != 0
                        || getImaginary().compareTo(new BigDecimal(getImaginary().toBigInteger())) != 0;
    }


    public boolean isComplexNumber()
    {
        return getImaginary().compareTo(BigDecimal.ZERO) != 0;
    }


    public boolean isNaN()
    {
        return getReal() == null;
    }


    public boolean isZero()
    {
        return getReal().compareTo(BigDecimal.ZERO) == 0 && getImaginary().compareTo(BigDecimal.ZERO) == 0;
    }


    private boolean isValid(int precision)
    {
        return precision > 0;
    }


    protected int getValidPrecision(int precision)
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
        return OrionPrinter.print(realValue);
    }


    public String printImaginaryValue()
    {
        String printed = OrionPrinter.print(imaginaryValue);
        if("NaN".equals(printed))
        {
            return printed;
        }
        else
        {
            return printed.startsWith("-") ? printed : "+" + printed;
        }
    }


    public String print()
    {
        boolean xExists = realValue != null;
        boolean yExists = imaginaryValue != null && BigDecimal.ZERO.compareTo(imaginaryValue) != 0;
        if(yExists)
        {
            return printComplexNumber();
        }
        else
        {
            return xExists ? printRealValue() : "NaN";
        }
    }


    private String printComplexNumber()
    {
        boolean xExists = realValue != null;
        int xComparisonValue = xExists ? BigDecimal.ZERO.compareTo(realValue) : 0;
        if(xComparisonValue != 0)
        {
            return printRealValue() + printImaginaryValue() + "i";
        }
        else
        {
            return printImaginaryValue() + "i";
        }
    }


    @Override
    public String toString()
    {
        return print();
    }


    public BigDecimal getReal()
    {
        return realValue;
    }


    public BigDecimal getImaginary()
    {
        return imaginaryValue;
    }
}