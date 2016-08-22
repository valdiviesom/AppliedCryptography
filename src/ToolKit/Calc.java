package ToolKit;

import FactoringAlgorithms.PrimeFactorization;
import PrimalityTest.PrimalityTest;
import org.jetbrains.annotations.Contract;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Mauricio on 7/19/2016.
 */
public class Calc {
    public static int maxIntValue = 2147483647;

    public static int modularExp(int base, int exp, int mod) {
        // tested
        if (mod == 1) return 0;
        int rsf = 1;
        base = base % mod;
        while (exp > 0) {
            if (exp % 2 == 1) {
                rsf = (rsf * base) % mod;
            }
            exp = exp >> 1;
            base = (base * base) % mod;
        }
        if (rsf < 0) rsf += mod;
        return rsf;
    }

    public static BigInteger modPow(BigInteger base, BigInteger expt, BigInteger mod) {
        // tested
        BigInteger rsf = BigInteger.ONE;
        while (expt.compareTo(BigInteger.ZERO) == 1) {
            if (mod(expt, BigInteger.valueOf(2)).compareTo(BigInteger.ONE) == 0) {
                rsf = mod(rsf.multiply(base), mod);
            }
            expt = expt.shiftRight(1);
            base = mod(base.multiply(base), mod);
        }
        rsf = mod(rsf, mod);
        return rsf;

    }

    public static BigInteger mod(BigInteger a, BigInteger n) {
        BigInteger q = a.divide(n);
        return a.subtract(n.multiply(q));
    }

    public static int abs(int n) {
        if (n < 0) return -n;
        return n;
    }

    public static int power(int base, int expt) {
        //tested
        assert (!(base == 0 && expt == 0));
        if (expt < 0) return power(1 / base, -expt);
        if (expt == 0) return 1;
        if (expt == 1) return base;
        if (expt % 2 == 0) return power(base * base, expt / 2);
        return base * power(base * base, (expt - 1) / 2);
    }

    public static int trivialPower(int base, int e) {
        //to test power
        if (e == 0) return 1;
        if (e == 1) return base;
        return base * trivialPower(base, e - 1);
    }

    public static int gcd(int a, int b) {
            // tested
        if (a == b) return a;
        if (a < b) return gcd(b, a);
        if (b == 1) return 1;
        if (b == 0) return a;
        int q = a / b;
        int r = a - b * q;
        if (r == 0) return b;
        return gcd(b, r);
    }

    public boolean divides(int a, int b) {
        return (b % a == 0);
    }

    public static BigInteger positive(BigInteger x) {
        if (x.compareTo(BigInteger.ZERO) == -1) return x.negate();
        return x;
    }

    public static BigInteger gcd(BigInteger a, BigInteger b) {
            //tested
        a = positive(a);
        b = positive(b);
        if (b.compareTo(BigInteger.ONE) == 0) return b;
        if (a.compareTo(b) == 0) return a;
        if (a.compareTo(b) == -1) return gcd(b, a);
        if (b.compareTo(BigInteger.ZERO) == 0) return a;
        BigInteger q = a.divide(b);
        BigInteger r = mod(a, b);
        if (r.compareTo(BigInteger.ZERO) == 0) return b;
        return gcd(b, r);
    }

    public static int mod(int a, int n) {
        int r = a % n;
        if (r < 0) return r + n;
        return r;
    }

    public static int eulerTotient(int n) {
        if (PrimalityTest.isPrime(n)) return n - 1;
        Set<Integer> divisors = new HashSet<Integer>();
        divisors.addAll(PrimeFactorization.primeFactorization(n));
        double product = 1;
        for (int p : divisors) {
            double x = (double) 1 / p;
            x = (double) 1 - x;
            product *= (double) x;
        }
        return (int) (n * product);
    }

    public static int multiplicativeInverseMod(int a, int n) {
        //TODO: here is the problem with RSA, fix this function for large values;
        assert (gcd(a, n) == 1);
        int phiN = eulerTotient(n);
        return modularExp(a, phiN - 1, n);
    }

    public static BigInteger modInversePhi(BigInteger a, BigInteger n) {
        System.out.println("modInversePhi");
        assert (gcd(a, n).compareTo(BigInteger.ONE) == 0);
        BigInteger phiN = eulerTotient(n);
        assert phiN != null;
        return modPow(a, phiN.subtract(BigInteger.ONE), n);
    }

    public static BigInteger eulerTotient(BigInteger n) {
        System.out.println("eulerTotient " + n);

        BigInteger rsf = BigInteger.ZERO;
        BigInteger a = n;
        while (n.compareTo(BigInteger.ONE) == 1) {
            a = a.subtract(BigInteger.ONE);
            System.out.println("start gcd " + a);
            if ((gcd(a, n)).compareTo(BigInteger.ONE) == 0) rsf = rsf.add(BigInteger.ONE);
            System.out.println("end gcd " + a);
        }
        System.out.println("finish eulerTotient " + n);

        return rsf;
    }

    public static boolean equals(BigInteger a, BigInteger b) {
        return (a.compareTo(b) == 0);
    }

    public static BigInteger modInverse(BigInteger a, BigInteger n) {
        BigInteger t = BigInteger.ZERO;
        BigInteger newt = BigInteger.ONE;
        BigInteger r = n;
        BigInteger newr = a;

        BigInteger quotient, temp;
        while (newr.compareTo(BigInteger.ZERO) != 0) {
            quotient = r.divide(newr);
            temp = newt;
            newt = t.subtract(quotient.multiply(newt));
            t = temp;
            temp = newr;
            newr = r.subtract(quotient.multiply(newr));
            r = temp;
        }
        return mod(t, n);
        /*
        int t = 0;
        int newt = 1;
        int r = n;
        int newr = a;
        int quotient, temp;
        while (newr != 0) {
            quotient = r / newr;
            temp = newt;
            newt = t - quotient * newt;
            t = temp;
            temp = newr;
            newr = r - quotient * newr;
            r = newr;
        }
        assert (r <= 1);
        return mod(t, n);*/
    }

    @Contract(pure = true)
    public static int inverse(int a, int n) {
        assert (gcd(a, n) == 1);
        BigInteger ba = BigInteger.valueOf(a);
        BigInteger bn = BigInteger.valueOf(n);
        BigInteger bb = ba.modInverse(bn);
        int b = bb.intValue();
//        assert (1 == (a * b) % n);
        return bb.intValue();
        //todo: fix the alg
    }
}
