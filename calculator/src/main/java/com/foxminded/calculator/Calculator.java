package com.foxminded.calculator;

import com.foxminded.calculator.model.Result;
import com.foxminded.calculator.model.Step;

import java.util.ArrayList;
import java.util.List;

import static com.foxminded.calculator.model.MathUtils.*;

public class Calculator {
    public Result process(int dividend, int divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException("Divisor cannot be zero");
        }
        if (Math.abs(dividend) < Math.abs(divisor)) {
            Step step = new Step(0, 0);
            List<Step> steps = new ArrayList<>();
            steps.add(step);
            return new Result(dividend, divisor, dividend / divisor, dividend % divisor, steps);
        }
        int checkIfDivisorNegative = 1;
        int checkIfDividendNegative = 1;
        if (divisor < 0) {
            checkIfDivisorNegative = -1;
        }
        if (dividend < 0) {
            checkIfDividendNegative = -1;
        }
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        int remainder = dividend % divisor;
        int quotient = dividend / divisor;
        int localDividend = 0;
        int intermediate = 0;
        int firstIndent = 0;
        List<Step> steps = new ArrayList<>();

        for (int i = 0; i <= findLength(quotient); i++) {
            if (i == 0) {
                if (findSeveralDigits(dividend, findLength(divisor)) < divisor) {
                    localDividend = findSeveralDigits(dividend, findLength(divisor) + 1);
                    firstIndent = findLength(localDividend);
                } else {
                    localDividend = findSeveralDigits(dividend, findLength(divisor));
                    firstIndent = findLength(localDividend);
                }
                intermediate = divisor * findDigit(quotient, 0);
            } else {
                localDividend = (localDividend - intermediate) * 10 + findDigit(dividend, i + firstIndent);
                intermediate = divisor * findDigit(quotient, i);
            }
            Step step = new Step(localDividend * checkIfDividendNegative, intermediate * checkIfDividendNegative);
            steps.add(step);
        }
        return new Result(dividend * checkIfDividendNegative,
                divisor * checkIfDivisorNegative,
                quotient * checkIfDividendNegative * checkIfDivisorNegative
                , remainder * checkIfDividendNegative,
                steps);
    }
}
	