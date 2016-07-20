package ToolKit.Tests;

import FactoringAlgorithms.PerfectPower;
import PrimalityTest.PrimalityTest;
import ToolKit.Generator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


/**
 * Created by Mauricio on 7/18/2016.
 */
public class GeneratorTests {

    @Test
    public void testRand() throws Exception {
        for (int i = 0; i < 10; i++) {
            int x = Generator.rand(10, 110);
            System.out.println(x);
        }
    }

    @Test
    public void primeofDigitsTest() {
        int p;
        for (int i = 1; i < 8; i++) {
            System.out.println(i);
            for (int j = 0; j < 20; j++) {
                p = Generator.primeOfDigits(i);
                System.out.print(p + " ");
                assertTrue(PrimalityTest.isPrime(p));
            }
            System.out.println();
        }
    }

    @Test
    public void productTest() {
        for (int i = 0; i < 15; i++) {
            int p, q;
            do {
                p = Generator.primeOfDigits(7);
                q = Generator.primeOfDigits(7);
            } while (p == q);
            int n = p * q;
        }
    }


}