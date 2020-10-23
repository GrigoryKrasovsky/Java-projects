package com.foxminded.calculator.model;

import java.util.List;
import java.util.Objects;

public class Result {
    private final int dividend;
    private final int divisor;
    private final int quotient;
    private final int remainder;

    private final List<Step> steps;

    public Result(int dividend, int divisor, int quotient, int remainder, List<Step> steps) {
        this.dividend = dividend;
        this.divisor = divisor;
        this.quotient = quotient;
        this.remainder = remainder;
        this.steps = steps;

    }

    public int getDividend() {
        return dividend;
    }

    public int getDivisor() {
        return divisor;
    }

    public int getQuotient() {
        return quotient;
    }

    public int getRemainder() {
        return remainder;
    }

    public List<Step> getSteps() {
        return steps;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result result = (Result) o;
        return dividend == result.dividend &&
                divisor == result.divisor &&
                quotient == result.quotient &&
                remainder == result.remainder &&
                Objects.equals(steps, result.steps);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dividend, divisor, quotient, remainder, steps);
    }
}
