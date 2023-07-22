package io.github.orionlibs.math.algebra.number;

import java.math.BigDecimal;

public interface ValidNumber
{
    default boolean isValid(String value)
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
}