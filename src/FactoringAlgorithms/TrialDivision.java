package FactoringAlgorithms;

import PrimalityTest.PrimalityTest;

/**
 * Created by Mauricio on 7/18/2016.
 */
public class TrialDivision extends PrimeFactorization {
    public static boolean isPrime(int n) {
        int trivial = trivialTests(n);
        return trivial != 0 && (trivial == 1 || aFactor(n) == n);

    }

    //requires n>2
    public static int aFactor(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return i;
        }
        return n;
    }
}
