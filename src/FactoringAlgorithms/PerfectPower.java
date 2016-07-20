package FactoringAlgorithms;

import ToolKit.Calc;

/**
 * Created by Mauricio on 7/18/2016.
 */
public class PerfectPower extends PrimeFactorization {
    /*
    determine if a natural number n is of the form n=a^b
     */
    public static boolean isPerfect(int n) {
        return theFactor(n) != -1;

    }

    public static int theFactor(int n) {
        if (n < 0) return -1;
        if (n < 2) return 1;
        //a>1, b>0 ergo a^b>=2 ergo b<=lg(n)
        int b = (int) Math.ceil(Math.log10(n) / Math.log10(2));
        int a;
        while (b > 1) {
            a = binarySearchA(n, b);
            if (a != -1 && n == Calc.power(a, b)) {
                /*System.out.print(n + " is a perfect power!   ");
                System.out.println(n + "=" + a + "^" + b);*/
                return a;
            }
            b--;
        }
        return -1;
    }


    public static int binarySearchA(int n, int b) {
        //know: 1<a<=n^(1/b), do a binary search to see which
        double max = Math.ceil(Math.pow(n, (double) 1 / b));
        return binaryHelper(n, b, 1, max, -1, -1);
    }

    public static int binaryHelper(int target, int pow, double min, double max, double pmin, double pmax) {
        int mid = (int) Math.round((max + min) / 2);
        int candidate = Calc.power(mid, pow);
        if (target == candidate) return mid;
        if (candidate > target) {
            if (pmin == mid && pmax == max) return -1;
            return binaryHelper(target, pow, min, min, min, max);
        }
        if (candidate < target) {
            if (pmin == mid && pmax == max) return -1;
            return binaryHelper(target, pow, mid, max, min, max);
        }
        return -1;
    }
}
