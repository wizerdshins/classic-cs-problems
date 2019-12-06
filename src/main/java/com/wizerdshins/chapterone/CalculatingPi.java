package com.wizerdshins.chapterone;

public class CalculatingPi {


    /**
     * example from book
     */

    private static int COUNT = 1000000;

    private double getPi(int count) {

        double result = 0.0;
        double numerator = 4.0;
        double denominator = 1.0;
        double operation = 1.0;

        for (int i = 0; i < count; i++) {
            result += operation * (numerator / denominator);
            denominator += 2.0;
            operation *= -1.0;
        }

        return result;

    }

    /**
     * Madhava–Leibniz formula
     */

    private double getPiUsingClassicFormula(int count) {
        double result = 0.0;
        for (int i = count; i > 0; i--) {
            result += Math.pow(-1, i + 1) / (2 * i - 1);
            if (i == 1) result *= 4;
        }
        return result;
    }

    /**
     * John Machin formula:
     * Pi/4 = 4arctg1/5 - arctg1/239
     */

    private double getPiUsingMachinFormula() {
        return 4.0 * (4 * Math.atan(5) - Math.atan(239)) / 5.0;
    }

    /**
     * best practice :-)
     */

    private double getPiUsingMathPackage() {
        return Math.PI;
    }


    public static void main(String[] args) {}
}
