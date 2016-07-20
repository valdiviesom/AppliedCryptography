package ToolKit;

/**
 * Created by Mauricio on 7/19/2016.
 */
public class Calc {
    public static int modularExp(int base, int exp, int mod) {
        //Todo: not fixed
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

    public static int abs(int n) {
        if (n < 0) return -n;
        return n;
    }

    public static int power(int base, int expt) {
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
        if (a == b) return a;
        if (a < b) return gcd(b, a);
        if (b == 1) return 1;
        if (b == 0) return a;
        int q = a / b;
        int r = a - b * q;
        if (r == 0) return b;
        return gcd(b, r);
    }

    public static int mod(int a, int n) {
        int r = a % n;
        if (r < 0) return r + n;
        return r;
    }
}
