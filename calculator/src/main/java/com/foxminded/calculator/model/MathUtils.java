package com.foxminded.calculator.model;

public final class MathUtils {
    private MathUtils() {
    }

    public static int findLength(int figure) {
        if (figure == 0) {
            return 0;
        }
        return (int) (Math.log10(Math.abs(figure)));
    }

    public static int findSeveralDigits(int figure, int lastIndex) {

        return figure / (int) Math.pow(10, findLength(figure) - lastIndex);
    }

    public static int findDigit(int figure, int index) {
        return figure / (int) Math.pow(10, findLength(figure) - index) % 10;

    }

}
