package FactoringAlgorithms.Tests;

import FactoringAlgorithms.PollardRho;
import ToolKit.Calc;
import ToolKit.Generator;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Mauricio on 7/19/2016.
 */
public class PollardRhoTest {

    @Test
    public void testAFactor() throws Exception {
        PollardRho.aFactor(16);
        int a, b;
        do {
            a = Generator.rand(1, 5);
            b = Generator.rand(0, 13);
        } while (Calc.gcd(a, b) > 1);
        for (int i = 0; i < 10; i++) {
            int n=a*i+b+15000;
            System.out.println("a factor of " + n + " is "+ PollardRho.aFactor(n));
        }
    }
}