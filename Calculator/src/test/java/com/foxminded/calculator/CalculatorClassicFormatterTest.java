package com.foxminded.calculator;

import com.foxminded.calculator.formatters.Formatter;
import com.foxminded.calculator.formatters.FormatterFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorClassicFormatterTest {
    Calculator calculator = new Calculator();

    @Test
    void shouldVerifyClassicFormatterIfAllPositive() {
        Formatter format = FormatterFactory.get("Classic");
        String expected = "_225|15\n" +
                " 15 |--\n" +
                " -- |15\n" +
                " _75\n" +
                "  75\n" +
                "  --\n" +
                "   0";
        assertEquals(expected, format.format(calculator.process(225, 15)));
    }

    @Test
    void shouldVerifyClassicFormatterIfDividendNegative() {
        Formatter format = FormatterFactory.get("Classic");
        String expected = "_-225|15\n" +
                " -15 |--\n" +
                "  -- |-15\n" +
                " _-75\n" +
                "  -75\n" +
                "   --\n" +
                "   0";
        assertEquals(expected, format.format(calculator.process(-225, 15)));
    }

    @Test
    void shouldVerifyClassicFormatterIfDivisorNegative() {
        Formatter format = FormatterFactory.get("Classic");
        String expected = "_225|-15\n" +
                " 15 |--\n" +
                " -- |-15\n" +
                " _75\n" +
                "  75\n" +
                "  --\n" +
                "   0";
        assertEquals(expected, format.format(calculator.process(225, -15)));
    }

    @Test
    void shouldVerifyClassicFormatterIfBothNegative() {
        Formatter format = FormatterFactory.get("Classic");
        String expected = "_-225|-15\n" +
                " -15 |--\n" +
                "  -- |15\n" +
                " _-75\n" +
                "  -75\n" +
                "   --\n" +
                "   0";
        assertEquals(expected, format.format(calculator.process(-225, -15)));
    }
}
