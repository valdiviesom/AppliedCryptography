package ToolKit;

import PrimalityTest.PrimalityTest;

/**
 * Created by Mauricio on 7/18/2016.
 */
public class Generator extends Calc{


    // cheap number generator, not cryptographically secure
    // @return random number x s.t. min<=x<=max
    public static int rand(int min, int max) {
        int x;
        do {
            double random = Math.random();
            int digits = (int) Math.ceil(Math.log(max));
            x = (int) Math.round(random * Math.pow(10, digits));
        } while (x < min || x > max);
        return x;
    }

    public static int nextPrime(int n) {
        if (n < 2) return 2;
        if (n % 2 == 0) n++;
        while (true) {
            if (PrimalityTest.isPrime(n)) return n;
            n += 2;
        }
    }

    public static int primeOfDigits(int n) {
        int min = (int) Math.pow(10, n);
        int max = (int) Math.pow(10, n);
        int p;
        do {
            int x = rand(min, max);
            p = nextPrime(x);
        } while (p < max);
        return p;
    }

    public static int primeFromRange(int min, int max) {
        int rand;
        int p;
        int attempts = 0;
        do {
            rand = rand(min, max);
            p = nextPrime(rand);
            attempts++;
        } while (p < max || attempts > 10);
        if (p < max) return p;
        if (nextPrime(min) > max) return -1;
        return -1;
    }
}
