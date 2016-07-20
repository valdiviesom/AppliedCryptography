package FactoringAlgorithms.Tests;

import FactoringAlgorithms.PrimeFactorization;
import PrimalityTest.PrimalityTest;
import ToolKit.Calc;
import ToolKit.Generator;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Mauricio on 7/19/2016.
 */
public class PrimeFactorizationTests {

    @Test
    public void testFactorization() throws Exception {
        int a, b;
        do {
            a = Generator.rand(1, 5);
            b = Generator.rand(0, 2000);
        } while (Calc.gcd(a, b) > 1);
        int product;
        for (int i = 2; i < 150; i++) {
            product=1;
            int n = a * i + b;
            List<Integer> factors = PrimeFactorization.primeFactorization(n);
            //System.out.print("The prime factors of " + n + " are: ");
            //System.out.println();
            for (Integer x : factors) {
                //System.out.print(x + " ");
                assertTrue(PrimalityTest.isPrime(x));
                product*=x;
            }
            assertEquals(n,product);
        }
    }
}