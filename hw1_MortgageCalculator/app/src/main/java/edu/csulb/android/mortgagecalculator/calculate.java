package edu.csulb.android.mortgagecalculator;
import java.lang.Math;

/**
 * Created by johnkmnguyen on 9/23/17.
 */

public class calculate
{
    public static double calculate(double p, double j, double n, double tax)
    {
        double g = Math.pow(1 + j, -n);
        double k = 1 - g;
        double x =(j / k);

        return (p * x) + tax;
        //return (p * (j/1-(Math.pow(1+j,-n)) + tax));
    }

    public static double calculateZero(double p, double n, double tax)
    {
        return ((p/n) + tax);
    }

}
