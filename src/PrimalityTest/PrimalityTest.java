package PrimalityTest;

import FactoringAlgorithms.TrialDivision;
import ToolKit.Calc;

/**
 * Created by Mauricio on 7/18/2016.
 */
public class PrimalityTest extends Calc {
    protected static int securityParameter = 6;
    static int MillerCutOff = 100000000;//todo: change after MillerRabin is fixed

    /**
     * @param n number being factored
     * @return 0 if definitely not prime,
     * 1 if definitely prime,
     * 2 if further tests needed
     */
    public static int trivialTests(int n) {
        if (n < 2) return 0;
        if (n == 2) return 1;
        if (n % 2 == 0) return 0;
        if (n == 3) return 1;
        return 2;
    }

    public static boolean isPrime(int n) {
        if (n < MillerCutOff) return TrialDivision.isPrime(n);
        return MillerRabin.isPrime(n, securityParameter);
    }

}
