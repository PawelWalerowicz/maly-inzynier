//Class with additional matematical functions

package main.common;

public class MathFunctions {
    private int decimalplaces;
    private double number;

    public static double round(double number, int decimalplaces) {
        double decimaloperator;
        if(decimalplaces>=0) {
            decimaloperator = Math.pow(10, decimalplaces);
            number = (Math.round(number * decimaloperator)) / decimaloperator;
            return number;
        } else return 0;

    }

    public static double interpolate(double x, double x0, double y0, double x1, double y1) {
            if (x1!=x0) {
            return y0 + (y1 - y0) / (x1 - x0) * (x - x0);
        } else return 0;

    }
}