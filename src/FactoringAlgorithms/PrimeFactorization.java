package FactoringAlgorithms;

import PrimalityTest.PrimalityTest;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Mauricio on 7/19/2016.
 */
public class PrimeFactorization extends PrimalityTest {

    public static List<Integer> primeFactorization(int n) {
        List<Integer> rsf = new LinkedList<Integer>();
        if (isPrime(n)) {
            rsf.add(n);
            return rsf;
        }
        int factor1;
        if (n < 350) factor1 = TrialDivision.aFactor(n);
        else {
            factor1 = PollardRho.aFactor(n);
            if (factor1 == -1) {
                int perfect = PerfectPower.theFactor(n);
                if (perfect != -1) {
                    int count = (int) (Math.log10(n) / Math.log10(perfect));
                    while (count > 0) {
                        rsf.add(perfect);
                        count--;
                    }
                    return rsf;
                }
                factor1 = TrialDivision.aFactor(n);
            }
        }
        int factor2 = n / factor1;
        rsf.addAll(primeFactorization(factor1));
        rsf.addAll(primeFactorization(factor2));
        return rsf;
    }
}
