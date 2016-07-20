package FactoringAlgorithms;

import ToolKit.Calc;

/**
 * Created by Mauricio on 7/18/2016.
 */
public class PollardRho extends PrimeFactorization {
    public static int aFactor(int n) {
        int x = 2;
        int y = 2;
        int d = 1;
        while (d == 1) {
            x = mod(x * x - 1, n);
            y = mod(y * y - 1, n);
            y = mod(y * y - 1, n);
            d = gcd(abs(x - y), n);
        }
        if (d == n) return -1;
        return d;
    }
}
