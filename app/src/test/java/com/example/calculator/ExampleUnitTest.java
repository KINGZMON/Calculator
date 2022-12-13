package com.example.calculator;

import org.junit.Test;
import org.mariuszgromada.math.mxparser.Expression;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void Test01Calculation() {
        String inputExp = "1+2";
        Expression exp = new Expression(inputExp);

        String expectedValue = "3.0";
        String actualValue = String.valueOf(exp.calculate());

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void Test02Calculation() {
        String inputExp = "1+2/3*4";
        Expression exp = new Expression(inputExp);

        String expectedValue = "3.6666666666666665";
        String actualValue = String.valueOf(exp.calculate());

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void Test03Calculation() {
        String inputExp = "9^2";
        Expression exp = new Expression(inputExp);

        String expectedValue = "81.0";
        String actualValue = String.valueOf(exp.calculate());

        assertEquals(expectedValue, actualValue);
    }

    @Test (expected = NullPointerException.class)
    public void Test04Calculation() {
        String inputExp = null;
        Expression exp = new Expression(inputExp);
        String actualValue = String.valueOf(exp.calculate());
    }


}