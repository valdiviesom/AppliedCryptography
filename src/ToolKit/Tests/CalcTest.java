package ToolKit.Tests;

import ToolKit.Generator;
import ToolKit.Calc;
import org.junit.Test;

import java.math.BigInteger;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Mauricio on 7/19/2016.
 */
public class CalcTest extends Calc {
    Random random = new Random();

    @Test
    public void BigModPowTest() { // done
        BigInteger base, mod, exp, n, delta;
        int size = 15;
        for (int i = 0; i < 100; i++) {
            do {
                base = new BigInteger(Generator.rand(1, size), random);
                mod = new BigInteger(Generator.rand(2, size), random);
                exp = new BigInteger(Generator.rand(2, size), random);
            } while ((base.multiply(mod.multiply(exp))).compareTo(BigInteger.ZERO) == 0);
            n = Calc.modPow(base, exp, mod);
            delta = n.subtract(base.modPow(exp, mod));
            assertEquals(0, delta.intValue());
        }
    }

    @Test
    public void modTest() { // done
        BigInteger a, b, n, delta;
        int size = 90;
        for (int i = 0; i < 10; i++) {
            a = new BigInteger(size, random);
            n = new BigInteger(size, random);
            b = mod(a, n);
            delta = b.subtract(a.mod(n));
            assertEquals(0, delta.intValue());
        }
    }

    @Test
    public void modularExpTest() {
        assertEquals(445, Calc.modularExp(4, 13, 497));
        int base, mod, exp, n;
        for (int i = 0; i < 15; i++) {
            base = Generator.rand(20, 50);
            mod = Generator.rand(2, 50);
            exp = Generator.rand(10, 20);
            n = Calc.power(base, exp);
            n = n % mod;
            if (n < 0) n += mod;
            assertEquals(n, Calc.modularExp(base, exp, mod));
            System.out.println("success!!");
        }
    }

    @Test
    public void powerTest() { // done
        int base, exp, n;
        for (int i = 0; i < 100; i++) {
            base = Generator.rand(2, 15);
            exp = Generator.rand(2, 20);
            //n = (int) (Math.pow(base, exp));
            n = Calc.trivialPower(base, exp);
            assertEquals(n, Calc.power(base, exp));
        }
    }

    @Test
    public void gcdTest() { // done
        assertEquals(65, Calc.gcd(65, 65));
        assertEquals(5, Calc.gcd(5, 5 * 78));
        assertEquals(1, Calc.gcd(7, 13));
    }

    @Test
    public void EulerTotientTests() { // passes
        assertEquals(12, eulerTotient(36));
        assertEquals(16, eulerTotient(32));
        assertEquals(66, eulerTotient(67));
        assertEquals(54, eulerTotient(81));
    }

    @Test
    public void modularInverseTest() {  // done, for small values
        int a, n;
        for (int i = 0; i < 20; i++) {
            do {
                a = Generator.rand(2, 3002);
                n = Generator.rand(2, 3000);
            } while (gcd(a, n) > 1);
            assertEquals(1, mod(a * multiplicativeInverseMod(a, n), n));
        }
    }

    @Test
    public void inverseTest() { // done
        int a, b, n;
        for (int i = 0; i < 100; i++) {
            do {
                a = Generator.rand(2, 50);
                n = Generator.rand(2, 50);
            } while (gcd(a, n) > 1);
            b = inverse(a, n) % n;
            assertEquals(1, (a * b) % n);
            //System.out.println("done");
        }
    }

    @Test
    public void bigGcdTest() { // done
        BigInteger a, b, g, delta;
        int size = 2500;
        for (int i = 0; i < 500; i++) {
            a = new BigInteger(size, random);
            b = new BigInteger(size, random);
            a = a.multiply(b);
            g = Calc.gcd(b, a);
            delta = g.subtract(a.gcd(b));
            assertTrue(b.subtract(g).compareTo(BigInteger.ZERO)==0);
            assertEquals(0, delta.compareTo(BigInteger.ZERO));

        }
    }

    @Test
    public void bigModInverseTest() {
        BigInteger a, b, n, m, delta;
        int size = 10;
        for (int i = 0; i < 50; i++) {
            do {
                a = new BigInteger(size, random);
                n = new BigInteger(size, random);
            } while (gcd(a, n).compareTo(BigInteger.ONE) != 0);
            System.out.println("here");
            b = modInversePhi(a, n);
            m = a.multiply(b);
            m = mod(m, n);
            assertTrue(m.compareTo(BigInteger.ONE)==0);
            System.out.println("done");
        }
    }


}