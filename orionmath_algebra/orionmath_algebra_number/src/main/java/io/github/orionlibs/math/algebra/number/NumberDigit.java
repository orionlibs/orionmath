package io.github.orionlibs.math.algebra.number;

import java.math.BigDecimal;

public interface NumberDigit
{
    static BigDecimal reverseDigits(BigDecimal x)
    {
        if(x != null)
        {
            String numberPart = x.toPlainString();
            if(x.compareTo(BigDecimal.ZERO) < 0)
            {
                //if -23 then this holds 23- so that after reversal it becomes -32
                numberPart = numberPart.substring(1) + "-";
            }
            return new BigDecimal(new StringBuilder(numberPart).reverse().toString());
        }
        else
        {
            return BigDecimal.ZERO;
        }
    }
}