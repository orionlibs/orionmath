package io.github.orionlibs.math.algebra.number;

import java.math.BigDecimal;

public interface NumberDigit
{
    default int getNumberOfDecimalDigits(BigDecimal x)
    {
        NumberRules.isNotNull(x);
        return x.stripTrailingZeros().scale();
    }


    default BigDecimal reverseDigits(BigDecimal x)
    {
        NumberRules.isNotNull(x);
        String numberPart = x.toPlainString();
        if(x.compareTo(BigDecimal.ZERO) < 0)
        {
            //if -23 then this holds 23- so that after reversal it becomes -32
            numberPart = numberPart.substring(1) + "-";
        }
        return new BigDecimal(new StringBuilder(numberPart).reverse().toString());
    }


    default int getSumOfDigits(BigDecimal x)
    {
        NumberRules.isNotNull(x);
        int sum = 0;
        char[] digits = x.toPlainString().toCharArray();
        for(char digit : digits)
        {
            if(digit != '-' && digit != '.')
            {
                sum += Integer.parseInt(Character.toString(digit));
            }
        }
        return sum;
    }
}