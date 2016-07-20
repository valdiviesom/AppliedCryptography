package ToolKit.Tests;

import ToolKit.Generator;
import ToolKit.Calc;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Mauricio on 7/19/2016.
 */
public class CalcTest extends Calc {
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
    public void powerTest() {
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
    public void gcdTest() {
        assertEquals(65, Calc.gcd(65, 65));
        assertEquals(5, Calc.gcd(5, 5 * 78));
        assertEquals(1, Calc.gcd(7, 13));
    }

    @Test
    public void EulerTotientTests() {
        assertEquals(12, eulerTotient(36));
        assertEquals(16, eulerTotient(32));
        assertEquals(66, eulerTotient(67));
        assertEquals(54, eulerTotient(81));
    }

    @Test
    public void modularInverseTest() {
        int a, n;
        for (int i = 0; i < 20; i++) {
            do {
                a = Generator.rand(2, 3002);
                n = Generator.rand(2, 3000);
            } while (gcd(a, n) > 1);
            assertEquals(1, mod(a * multiplicativeInverseMod(a, n), n));
        }
    }


}