package PrimalityTest;

import ToolKit.Generator;

/**
 * Created by Mauricio on 7/18/2016.
 */
public class MillerRabin extends PrimalityTest {

    public static boolean isPrime(int n, int t) {
        //TODO fix by comparing with trialDivision
        // current error is 15% against trialDivision
        int trivial = trivialTests(n);
        if (trivial == 0) {
            return false;
        }
        if (trivial == 1) {
            return true;
        }
        int s, r;
        s = findS(n);
        r = (int) ((n - 1) / Math.pow(2, s));
        for (int i = 0; i < t; i++) {
            int a = Generator.rand(2, n - 2);
            int y = (int) (Math.pow(a, r) % n);
            if (y != 1 && y != (n - 1)) {
                int j = 1;
                while (j <= (s - 1) && y != (n - 1)) {
                    y = (y * y) % n;
                    if (y == 1) return false;
                    j++;
                }
                if (y != (n - 1)) return false;
            }
        }
        return true;
    }

    public static int findS(int n) {
        int s = 0;
        n--;
        while (n % 2 == 0) {
            s++;
            n /= 2;
        }
        return s;
    }

    public static boolean wiki(int n, int t) {
        // more mistakes than is prime, table for now
        int trivial = trivialTests(n);
        if (trivial == 0) {
            return false;
        }
        if (trivial == 1) {
            return true;
        }
        int r = findS(n);
        int d = (int) ((n - 1) / Math.pow(2, r));
        for (int i = 0; i < t; i++) {
            int a = Generator.rand(2, n - 2);
            int x = (int) Math.pow(a, d);
            x = x % n;
            if (!(x == 1 || x == (n - 1))) {
                for (int j = 0; j < r - 1; j++) {
                    if (x==(n-1)) break;
                    x *= x;
                    x = x % n;
                    if (x == 1) return false;
                    //if (x != (n - 1)) return false;
                }
            }
        }
        return true;
    }

}
