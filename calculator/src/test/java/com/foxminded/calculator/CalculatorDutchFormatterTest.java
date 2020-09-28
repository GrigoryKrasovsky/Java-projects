package com.foxminded.calculator;

import com.foxminded.calculator.formatters.Formatter;
import com.foxminded.calculator.formatters.FormatterFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorDutchFormatterTest {
    Calculator calculator = new Calculator();

    @Test
    void shouldVerifyDutchFormatterIfBothNegative() {
        Formatter format = FormatterFactory.get("Dutch");
        String expected = "-15/_-225\\15\n" +
                "     -15\n" +
                "      --\n" +
                "     _-75\n" +
                "      -75\n" +
                "      --\n" +
                "       0";
        assertEquals(expected, format.format(calculator.process(-225, -15)));
    }

    @Test
    void shouldVerifyDutchFormatterIfDivisorNegative() {
        Formatter format = FormatterFactory.get("Dutch");
        String expected = "-15/_225\\-15\n" +
                "     15\n" +
                "     --\n" +
                "     _75\n" +
                "      75\n" +
                "      --\n" +
                "       0";
        assertEquals(expected, format.format(calculator.process(225, -15)));
    }

    @Test
    void shouldVerifyDutchFormatterIfAllPositive() {
        Formatter format = FormatterFactory.get("Dutch");
        String expected = "15/_225\\15\n" +
                "    15\n" +
                "    --\n" +
                "    _75\n" +
                "     75\n" +
                "     --\n" +
                "      0";
        assertEquals(expected, format.format(calculator.process(225, 15)));
    }

    @Test
    void shouldVerifyDutchFormatterIfDividendNegative() {
        Formatter format = FormatterFactory.get("Dutch");
        String expected = "15/_-225\\-15\n" +
                "    -15\n" +
                "     --\n" +
                "    _-75\n" +
                "     -75\n" +
                "     --\n" +
                "      0";
        assertEquals(expected, format.format(calculator.process(-225, 15)));
    }
}