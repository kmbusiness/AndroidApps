package edu.csulb.android.temperatureconverter;
import java.lang.Math;
/**
 * Created by johnkmnguyen on 9/20/17.
 */

public class utility
{
    // From Fahrenheit to Celsius
    public static float convertFtoC (float fahrenheit)
    {
        return ((fahrenheit - 32) * 5 / 9);
    }

    // From Celsius to Fahrenheit
    public static float convertCtoF (float celsius)
    {
        return ((celsius * 9) / 5) + 32;
    }
}
