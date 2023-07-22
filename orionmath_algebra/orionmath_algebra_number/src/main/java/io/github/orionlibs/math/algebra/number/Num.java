package io.github.orionlibs.math.algebra.number;

public final class Num extends ANum
{
    private Num()
    {
        super();
    }


    private Num(boolean isNaN)
    {
        super(isNaN);
    }


    private Num(Number realValue)
    {
        super(realValue);
    }


    private Num(Number realValue, Number imaginaryValue)
    {
        super(realValue, imaginaryValue);
    }


    /*private ANumb(ANumb realValue, ANumb imaginaryValue)
    {
        NumberRules.areNotNull(realValue, imaginaryValue);
        new NumberInternalService().saveNumberValues(this, realValue.get().toString(), imaginaryValue.get().toString());
    }


    private ANumb(Number realValue, ANumb imaginaryValue)
    {
        NumberRules.areNotNull(realValue, imaginaryValue);
        new NumberInternalService().saveNumberValues(this, realValue.toString(), imaginaryValue.get().toPlainString());
    }


    private ANumb(ANumb realValue, Number imaginaryValue)
    {
        NumberRules.areNotNull(realValue, imaginaryValue);
        new NumberInternalService().saveNumberValues(this, realValue.get().toPlainString(), imaginaryValue.toString());
    }*/


    private Num(String realValue)
    {
        super(realValue);
    }


    private Num(String realValue, String imaginaryValue)
    {
        super(realValue, imaginaryValue);
    }


    public static Num of()
    {
        return new Num();
    }


    public static Num of(boolean isNaN)
    {
        return new Num(isNaN);
    }


    public static Num of(Number realValue)
    {
        return new Num(realValue);
    }


    public static Num of(Number realValue, Number imaginaryValue)
    {
        return new Num(realValue, imaginaryValue);
    }


    public static Num of(String realValue)
    {
        return new Num(realValue);
    }


    public static Num of(String realValue, String imaginaryValue)
    {
        return new Num(realValue, imaginaryValue);
    }


    /*public static ANumb ofPrecision(Number realValue, int precision)
    {
        ANumb temp = new ANumb(realValue);
        temp.applyPrecision(precision);
        return temp;
    }


    public static ANumb of(ANumb realValue, ANumb imaginaryValue)
    {
        return new ANumb(realValue, imaginaryValue);
    }


    public static ANumb of(Number realValue, ANumb imaginaryValue)
    {
        return new ANumb(realValue, imaginaryValue);
    }


    public static ANumb of(ANumb realValue, Number imaginaryValue)
    {
        return new ANumb(realValue, imaginaryValue);
    }


    public static ANumb ofPolarCoordinates(ANumb modulus, ANumb argument)
    {
        return new ANumb(modulus.multiplyGET(argument.getCosine()), modulus.multiplyGET(argument.getSine()));
    }*/


    public static Num ofNaN()
    {
        return new Num(true);
    }


    public static Num ofMin()
    {
        return new Num("-999999999999999999999999999999999999999999999999999999999999999999999999999999.0");
    }


    public static Num ofMax()
    {
        return new Num("999999999999999999999999999999999999999999999999999999999999999999999999999999.0");
    }


    public Num reverseDigits()
    {
        return Num.of(reverseDigits(getReal()), reverseDigits(getImaginary()));
    }


    /*public void applyPrecision()
    {
        PrecisionService.applyPrecision(this);
    }


    public ANumb applyPrecisionGET()
    {
        ANumb copy = getCopy();
        copy.applyPrecision();
        return copy;
    }


    public void applyPrecision(int precision)
    {
        new PrecisionService().applyPrecision(this, precision);
    }


    public ANumb applyPrecisionGET(int precision)
    {
        ANumb copy = getCopy();
        copy.applyPrecision(precision);
        return copy;
    }


    public boolean hasIntegerValue()
    {
        return Numbers.hasIntegerValue(this);
    }


    public boolean hasInfiniteValue()
    {
        return hasPositiveInfiniteValue() || hasNegativeInfiniteValue();
    }


    public boolean hasPositiveInfiniteValue()
    {
        return isGreaterThanOrEqual(ANumb.ofMax());
    }


    public boolean hasNegativeInfiniteValue()
    {
        return isLessThanOrEqual(ANumb.ofMin());
    }


    public boolean imaginaryValueHasIntegerValue()
    {
        return Numbers.imaginaryValueHasIntegerValue(getImaginaryValue());
    }


    public boolean hasDecimalValue()
    {
        return Numbers.hasDecimalValue(this);
    }


    public boolean isComplexNumber()
    {
        return getNumberType().is(NumberType.ComplexNumber);
    }


    public boolean isPositiveInfiniteNumber()
    {
        return getNumberType().is(NumberType.PositiveInfinityNumber) || equal(ofMax());
    }


    public boolean isNegativeInfiniteNumber()
    {
        return getNumberType().is(NumberType.NegativeInfinityNumber) || equal(ofMin());
    }


    public boolean isNaN()
    {
        return getRealValue() == null;
    }


    public boolean isZero()
    {
        return Numbers.isZero(this);
    }


    public boolean isNotZero()
    {
        return !isZero();
    }


    public boolean isOne()
    {
        return Numbers.isOne(this);
    }


    public boolean isNotOne()
    {
        return Numbers.isNotOne(this);
    }


    public boolean isMinusOne()
    {
        return Numbers.isMinusOne(this);
    }


    public boolean isNotMinusOne()
    {
        return !isMinusOne();
    }


    public boolean isPositive()
    {
        return Numbers.isPositive(this);
    }


    public boolean isNegative()
    {
        return !isPositive() && isNotZero();
    }


    public boolean isNonPositive()
    {
        return Numbers.isNonPositive(this);
    }


    public boolean isNonNegative()
    {
        return Numbers.isNonNegative(this);
    }


    public boolean isPrime()
    {
        return PrimeNumberService.isPrimeNumber(this);
    }


    public void negate()
    {
        ArithmeticService.negate(this);
    }


    public ANumb negateGET()
    {
        ANumb copy = getCopy();
        copy.negate();
        return copy;
    }


    public void reciprocate()
    {
        ArithmeticService.reciprocate(this);
    }


    public ANumb reciprocateGET()
    {
        ANumb newNumber = getCopy();
        newNumber.reciprocate();
        return newNumber;
    }


    public BigDecimal getModulusAsDecimal()
    {
        return new NumberInternalService().getModulus(this).get();
    }


    public ANumb getModulus()
    {
        return new NumberInternalService().getModulus(this);
    }


    public void setNewValues(Number realValue, Number imaginaryValue, int precision)
    {
        new NumberInternalService().setNewValues(this, realValue, imaginaryValue, precision);
    }


    public void setNewValues(Number realValue, Number imaginaryValue)
    {
        setNewValues(realValue, imaginaryValue, Precision.precision);
    }


    public void setNewValues(ANumb realValue, ANumb imaginaryValue)
    {
        NumberRules.areNotNull(realValue, imaginaryValue);
        new NumberInternalService().setNewValues(this, realValue.get(), imaginaryValue.get());
    }


    public void setNewValues(ANumb newValue)
    {
        NumberRules.isNotNull(newValue);
        new NumberInternalService().setNewValues(this, newValue.get(), newValue.getImaginaryValue());
    }


    public boolean divides(ANumb other)
    {
        return ArithmeticService.divides(this, other);
    }


    public boolean divides(Number other)
    {
        return ArithmeticService.divides(this, other);
    }


    public boolean isDividedBy(ANumb other)
    {
        return ArithmeticService.isDividedBy(this, other);
    }


    public boolean isDividedBy(Number other)
    {
        return ArithmeticService.isDividedBy(this, other);
    }


    public void round()
    {
        ANumb roundedNumber = ArithmeticService.round(this);
        setRealValue(roundedNumber.get());
        setImaginaryValue(roundedNumber.getImaginaryValue());
    }


    public ANumb roundGET()
    {
        return ArithmeticService.round(this);
    }


    public void round(int precision)
    {
        ANumb roundedNumber = ArithmeticService.round(this, precision);
        setRealValue(roundedNumber.get());
        setImaginaryValue(roundedNumber.getImaginaryValue());
    }


    public ANumb roundGET(int precision)
    {
        return ArithmeticService.round(this, precision);
    }


    public void round(RoundingMode roundingMode)
    {
        ANumb roundedNumber = ArithmeticService.round(this, roundingMode);
        setRealValue(roundedNumber.get());
        setImaginaryValue(roundedNumber.getImaginaryValue());
    }


    public ANumb roundGET(RoundingMode roundingMode)
    {
        return ArithmeticService.round(this, roundingMode);
    }


    public void round(int precision, RoundingMode roundingMode)
    {
        ANumb roundedNumber = ArithmeticService.round(this, precision, roundingMode);
        setRealValue(roundedNumber.get());
        setImaginaryValue(roundedNumber.getImaginaryValue());
    }


    public ANumb roundGET(int precision, RoundingMode roundingMode)
    {
        return ArithmeticService.round(this, precision, roundingMode);
    }


    public int getSignum()
    {
        return get().signum();
    }


    public boolean isEven()
    {
        return Numbers.isEven(this);
    }


    public boolean isOdd()
    {
        return Numbers.isOdd(this);
    }


    public boolean isLessThan(ANumb other)
    {
        return Numbers.isLessThan(this, other);
    }


    public boolean isLessThan(Number other)
    {
        return Numbers.isLessThan(this, other);
    }


    public boolean isLessThan(Constant other)
    {
        return Numbers.isLessThan(this, other);
    }


    public boolean isLessThanOrEqual(ANumb other)
    {
        return Numbers.isLessThanOrEqual(this, other);
    }


    public boolean isLessThanOrEqual(Number other)
    {
        return Numbers.isLessThanOrEqual(this, other);
    }


    public boolean isLessThanOrEqual(Constant other)
    {
        return Numbers.isLessThanOrEqual(this, other);
    }


    public boolean isGreaterThan(ANumb other)
    {
        return Numbers.isGreaterThan(this, other);
    }


    public boolean isGreaterThan(Number other)
    {
        return Numbers.isGreaterThan(this, other);
    }


    public boolean isGreaterThan(Constant other)
    {
        return Numbers.isGreaterThan(this, other);
    }


    public boolean isGreaterThanOrEqual(ANumb other)
    {
        return Numbers.isGreaterThanOrEqual(this, other);
    }


    public boolean isGreaterThanOrEqual(Number other)
    {
        return Numbers.isGreaterThanOrEqual(this, other);
    }


    public boolean isGreaterThanOrEqual(Constant other)
    {
        return Numbers.isGreaterThanOrEqual(this, other);
    }


    public boolean equal(ANumb other)
    {
        return equals(other);
    }


    public boolean equal(Number other)
    {
        return equals(ANumb.of(other));
    }


    public boolean notEqual(ANumb other)
    {
        return !equal(other);
    }


    public boolean notEqual(Number other)
    {
        return !equal(other);
    }


    public Fraction getRealValueAsFraction()
    {
        return NumberService.convertNumberToFraction(get());
    }


    public Fraction getImaginaryValueAsFraction()
    {
        return NumberService.convertNumberToFraction(getImaginaryValue());
    }


    public Fraction getAsFraction()
    {
        return getRealValueAsFraction();
    }


    public void addOne()
    {
        setRealValue(get().add(BigDecimal.ONE));
    }


    public ANumb addOneGET()
    {
        return new NumberInternalService().addOneGET(this);
    }


    public void subtractOne()
    {
        setRealValue(get().subtract(BigDecimal.ONE));
    }


    public ANumb subtractOneGET()
    {
        ANumb newNumber = getCopy();
        newNumber.setRealValue(newNumber.get().subtract(BigDecimal.ONE));
        return newNumber;
    }


    public void half()
    {
        setRealValue(get().divide(BigDecimal.valueOf(2)));
        setImaginaryValue(getImaginaryValue().divide(BigDecimal.valueOf(2)));
    }


    public void half(int precision)
    {
        setRealValue(get().divide(BigDecimal.valueOf(2)));
        setImaginaryValue(getImaginaryValue().divide(BigDecimal.valueOf(2)));
        applyPrecision(precision);
    }


    public ANumb halfGET()
    {
        ANumb newNumber = getCopy();
        newNumber.half();
        return newNumber;
    }


    public ANumb halfGET(int precision)
    {
        ANumb newNumber = getCopy();
        newNumber.half(precision);
        return newNumber;
    }


    public ANumb addGET(ANumb other)
    {
        return new NumberInternalService().addGET(this, other);
    }


    public ANumb addGET(Number other)
    {
        return new NumberInternalService().addGET(this, other);
    }


    public ANumb addGET(List<?> others, boolean checkForNullNumbers)
    {
        return new NumberInternalService().addGET(this, others, checkForNullNumbers);
    }


    public ANumb addGET(List<?> others, int precision, boolean checkForNullNumbers)
    {
        return new NumberInternalService().addGET(this, others, precision, checkForNullNumbers);
    }


    public void add(List<?> others)
    {
        ANumb newNumber = addGET(others, false);
        setRealValue(newNumber.get());
        setImaginaryValue(newNumber.getImaginaryValue());
    }


    public void add(List<?> others, int precision, boolean checkForNullNumbers)
    {
        ANumb newNumber = addGET(others, precision, checkForNullNumbers);
        setRealValue(newNumber.get());
        setImaginaryValue(newNumber.getImaginaryValue());
    }


    public void add(ANumb other)
    {
        ANumb newNumber = addGET(other);
        setRealValue(newNumber.get());
        setImaginaryValue(newNumber.getImaginaryValue());
    }


    public void add(Number other)
    {
        ANumb newNumber = addGET(other);
        setRealValue(newNumber.get());
        setImaginaryValue(newNumber.getImaginaryValue());
    }


    public ANumb subtractGET(ANumb other)
    {
        return new NumberInternalService().subtractGET(this, other);
    }


    public ANumb subtractGET(Number other)
    {
        return new NumberInternalService().subtractGET(this, other);
    }


    public void subtract(ANumb other)
    {
        ANumb newNumber = subtractGET(other);
        setRealValue(newNumber.get());
        setImaginaryValue(newNumber.getImaginaryValue());
    }


    public void subtract(Number other)
    {
        ANumb newNumber = subtractGET(other);
        setRealValue(newNumber.get());
        setImaginaryValue(newNumber.getImaginaryValue());
    }


    public ANumb multiplyGET(ANumb other)
    {
        return new NumberInternalService().multiplyGET(this, other);
    }


    public ANumb multiplyGET(Number other)
    {
        return new NumberInternalService().multiplyGET(this, other);
    }


    public ANumb multiplyGET(List<?> others, boolean checkForNullNumbers)
    {
        return new NumberInternalService().multiplyGET(this, others, checkForNullNumbers);
    }


    public void multiply(List<?> others)
    {
        ANumb newNumber = multiplyGET(others, false);
        setRealValue(newNumber.get());
        setImaginaryValue(newNumber.getImaginaryValue());
    }


    public void multiply(ANumb other)
    {
        ANumb newNumber = multiplyGET(other);
        setRealValue(newNumber.get());
        setImaginaryValue(newNumber.getImaginaryValue());
    }


    public void multiply(Number other)
    {
        ANumb newNumber = multiplyGET(other);
        setRealValue(newNumber.get());
        setImaginaryValue(newNumber.getImaginaryValue());
    }


    public ANumb divideGET(ANumb other)
    {
        return new NumberInternalService().divideGET(this, other);
    }


    public ANumb divideGET(Number other)
    {
        return new NumberInternalService().divideGET(this, other);
    }


    public void divide(ANumb other)
    {
        ANumb newNumber = divideGET(other);
        setRealValue(newNumber.get());
        setImaginaryValue(newNumber.getImaginaryValue());
    }


    public void divide(Number other)
    {
        ANumb newNumber = divideGET(other);
        setRealValue(newNumber.get());
        setImaginaryValue(newNumber.getImaginaryValue());
    }


    public DivisionResult divideAndRemainder(ANumb other)
    {
        return ArithmeticService.divideAndRemainder(this, other);
    }


    public DivisionResult divideAndRemainder(Number other)
    {
        return ArithmeticService.divideAndRemainder(this, other);
    }


    public ANumb getMinimum(ANumb other)
    {
        return ArithmeticService.getMinimum(Arrays.asList(this, other));
    }


    public ANumb getMinimum(Number other)
    {
        return ArithmeticService.getMinimum(Arrays.asList(this, other));
    }


    public ANumb getMinimum(List<ANumb> others)
    {
        List<ANumb> numbers = new ArrayList<>();
        numbers.add(this);
        numbers.addAll(others);
        return ArithmeticService.getMinimum(others);
    }


    public ANumb getMaximum(ANumb other)
    {
        return ArithmeticService.getMaximum(Arrays.asList(this, other));
    }


    public ANumb getMaximum(Number other)
    {
        return ArithmeticService.getMaximum(Arrays.asList(this, other));
    }


    public ANumb getMaximum(List<ANumb> others)
    {
        List<ANumb> numbers = new ArrayList<>();
        numbers.add(this);
        numbers.addAll(others);
        return ArithmeticService.getMaximum(others);
    }


    public ANumb getSine()
    {
        return TrigonometryService.getSineInRadians(this);
    }


    public ANumb getSine(int precision)
    {
        return TrigonometryService.getSineInRadians(this, precision);
    }


    public ANumb getArcsine()
    {
        return TrigonometryService.getArcsineAsRadians(this);
    }


    public ANumb getArcsine(int precision)
    {
        return TrigonometryService.getArcsineAsRadians(this, precision);
    }


    public ANumb getSineInDegrees()
    {
        return TrigonometryService.getSineInDegrees(this);
    }


    public ANumb getSineInDegrees(int precision)
    {
        return TrigonometryService.getSineInDegrees(this, precision);
    }


    public ANumb getCosine()
    {
        return TrigonometryService.getCosineInRadians(this);
    }


    public ANumb getCosine(int precision)
    {
        return TrigonometryService.getCosineInRadians(this, precision);
    }


    public ANumb getCosineInDegrees()
    {
        return TrigonometryService.getCosineInDegrees(this);
    }


    public ANumb getCosineInDegrees(int precision)
    {
        return TrigonometryService.getCosineInDegrees(this, precision);
    }


    public ANumb getArccosine()
    {
        return TrigonometryService.getArccosineAsRadians(this);
    }


    public ANumb getArccosine(int precision)
    {
        return TrigonometryService.getArccosineAsRadians(this, precision);
    }


    public ANumb getTangent()
    {
        return TrigonometryService.getTangentInRadians(this);
    }


    public ANumb getTangent(int precision)
    {
        return TrigonometryService.getTangentInRadians(this, precision);
    }


    public ANumb getTangentInDegrees()
    {
        return TrigonometryService.getTangentInDegrees(this);
    }


    public ANumb getTangentInDegrees(int precision)
    {
        return TrigonometryService.getTangentInDegrees(this, precision);
    }


    public ANumb getArctan()
    {
        return TrigonometryService.getArctangentAsRadians(this);
    }


    public ANumb getArctan(int precision)
    {
        return TrigonometryService.getArctangentAsRadians(this, precision);
    }


    public ANumb getCeiling()
    {
        return NumberService.getCeiling(this);
    }


    public ANumb getFloor()
    {
        return NumberService.getFloor(this);
    }


    public ANumb getNthRoot(int n)
    {
        return ArithmeticService.getNthRoot(this, n);
    }


    public ANumb getNthRoot(int n, int precision)
    {
        return ArithmeticService.getNthRoot(this, n, precision);
    }


    public ANumb getNeperianLogarithm()
    {
        return ArithmeticService.getNeperianLogarithm(this);
    }


    public ANumb getNeperianLogarithm(int precision)
    {
        return ArithmeticService.getNeperianLogarithm(this, precision);
    }


    public ANumb getLogarithm(ANumb base)
    {
        return ArithmeticService.getLogarithm(base, this);
    }


    public ANumb getLogarithm(Number base)
    {
        return ArithmeticService.getLogarithm(base, this);
    }


    public ANumb getLogarithm(ANumb base, int precision)
    {
        return ArithmeticService.getLogarithm(base, this, precision);
    }


    public ANumb getLogarithm(Number base, int precision)
    {
        return ArithmeticService.getLogarithm(base, this, precision);
    }


    public ANumb exponentiateGET(ANumb exponent)
    {
        return new NumberInternalService().exponentiateGET(this, exponent);
    }


    public ANumb exponentiateGET(Number exponent)
    {
        return new NumberInternalService().exponentiateGET(this, exponent);
    }


    public void exponentiate(ANumb exponent)
    {
        ANumb newNumber = exponentiateGET(exponent);
        setRealValue(newNumber.get());
        setImaginaryValue(newNumber.getImaginaryValue());
    }


    public void exponentiate(Number exponent)
    {
        ANumb newNumber = exponentiateGET(exponent);
        setRealValue(newNumber.get());
        setImaginaryValue(newNumber.getImaginaryValue());
    }


    public ANumb squareGET()
    {
        return multiplyGET(this);
    }


    public void square()
    {
        multiply(this);
    }


    public ANumb doubleGET()
    {
        return multiplyGET(2);
    }


    public void doubleIt()
    {
        multiply(2);
    }


    public ANumb getSquareRoot()
    {
        return getNthRoot(2);
    }


    public ANumb getSquareRoot(int precision)
    {
        return getNthRoot(2, precision);
    }


    public ANumb getAbsoluteValue()
    {
        return ArithmeticService.getAbsoluteValue(this);
    }


    public ANumb getRemainderOfDivision(ANumb divisor)
    {
        return ArithmeticService.getRemainderOfDivision(this, divisor);
    }


    public ANumb getRemainderOfDivision(Number divisor)
    {
        return ArithmeticService.getRemainderOfDivision(this, divisor);
    }


    public ANumb conjugate()
    {
        return NumberService.conjugate(this);
    }


    public ANumb getArgument()
    {
        return NumberService.getArgument(this);
    }


    public ANumb getPowerOf2GreaterOrEqualToThisNumber()
    {
        return NumberService.getPowerOf2GreaterOrEqualToThisNumber(this);
    }


    public boolean getParity()
    {
        return NumberService.getParity(this);
    }


    public boolean hasOddParity()
    {
        return NumberService.hasOddParity(this);
    }


    public boolean hasEvenParity()
    {
        return NumberService.hasEvenParity(this);
    }


    public boolean isPowerOf2()
    {
        return NumberService.isPowerOf2(this);
    }


    public boolean isNotPowerOf2()
    {
        return NumberService.isNotPowerOf2(this);
    }


    public boolean isUgly()
    {
        return NumberService.isUgly(this);
    }


    public boolean isCongruentModuloN(ANumb y, ANumb n)
    {
        return NumberService.isCongruentModuloN(this, y, n);
    }


    public boolean isHalfInteger()
    {
        return NumberService.isHalfInteger(this);
    }


    public ANumb getOrderOfMagnitude()
    {
        return NumberService.getOrderOfMagnitude(this);
    }


    public ANumb getIntegerPart()
    {
        ANumb temp = getCopy();
        temp.setRealValue(new BigDecimal(getAsBigInteger()));
        temp.setImaginaryValue(new BigDecimal(getImaginaryValueAsBigInteger()));
        return temp;
    }


    public ANumb getDecimalPart()
    {
        return ANumb.of(this.subtractGET(getIntegerPart()).get());
    }


    public void reset()
    {
        setRealValue(BigDecimal.ZERO);
        setImaginaryValue(BigDecimal.ZERO);
        setPrecision(Precision.precision);
    }


    public ANumb resetGET()
    {
        ANumb newNumber = this.getCopy();
        newNumber.reset();
        return newNumber;
    }


    @Override
    public int hashCode()
    {
        return NumberInternalService.hashCode(this);
    }


    @Override
    public boolean equals(Object object)
    {
        return NumberInternalService.equals(this, object);
    }


    @Override
    public int compareTo(ANumb other)
    {
        return NumberInternalService.compareTo(this, other);
    }


    public int compareTo(Number other)
    {
        return NumberInternalService.compareTo(this, other);
    }


    public BigInteger getAsInteger()
    {
        return NumberInternalService.getRealValueAsBigInteger(this);
    }


    public int getAsInt()
    {
        return getAsInteger().intValue();
    }


    public long getAsLong()
    {
        return getAsInteger().longValue();
    }


    public double getAsDouble()
    {
        return get().doubleValue();
    }


    public BigDecimal getAsDecimalCopy()
    {
        return new BigDecimal(get().toPlainString());
    }


    public ANumb getAsANumb()
    {
        return ANumb.of(get());
    }


    public ANumb getAsANumbCopy()
    {
        return ANumb.of(getAsDecimalCopy());
    }


    public BigInteger getAsBigInteger()
    {
        return NumberInternalService.getRealValueAsBigInteger(this);
    }


    public void setRealValue(BigDecimal realValue)
    {
        this.realValue = realValue;
    }


    public void setRealValue(ANumb realValue)
    {
        this.realValue = realValue.get();
    }


    public BigInteger getImaginaryValueAsBigInteger()
    {
        return NumberInternalService.getImaginaryValueAsBigInteger(this);
    }


    public BigDecimal getImaginaryValueCopy()
    {
        return new BigDecimal(getImaginaryValue().toPlainString());
    }


    public ANumb getImaginaryValueAsANumb()
    {
        return ANumb.of(getImaginaryValue());
    }


    public ANumb getImaginaryValueAsANumbCopy()
    {
        return ANumb.of(getImaginaryValueCopy());
    }


    public BigDecimal getImaginaryValue()
    {
        return imaginaryValue;
    }


    public void setImaginaryValue(BigDecimal imaginaryValue)
    {
        this.imaginaryValue = imaginaryValue;
    }


    public void setImaginaryValue(ANumb imaginaryValue)
    {
        this.imaginaryValue = imaginaryValue.get();
    }


    public void setImaginaryValueAsNull()
    {
        this.imaginaryValue = null;
    }


    public int getPrecision()
    {
        return precision;
    }


    public void setPrecision(int precision)
    {
        this.precision = precision;
    }


    public boolean isValidNumber()
    {
        return this.isValidNumber;
    }


    public void setValidNumber(boolean isValidNumber)
    {
        this.isValidNumber = isValidNumber;
    }


    public NumberType getNumberType()
    {
        return NumberInternalService.getNumberType(this);
    }


    @Override
    public ANumb clone() throws CloneNotSupportedException
    {
        return (ANumb)CloningService.clone(this);
    }


    public ANumb getCopy()
    {

        try
        {
            return this.clone();
        }
        catch(CloneNotSupportedException e)
        {
            e.printStackTrace();
        }

        return null;
    }


    public boolean isFinite()
    {
        return this.isFinite;
    }


    public boolean isInfinite()
    {
        return !isFinite();
    }*/
}