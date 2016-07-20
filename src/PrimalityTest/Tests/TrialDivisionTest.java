package PrimalityTest.Tests;

import PrimalityTest.MillerRabin;
import FactoringAlgorithms.TrialDivision;
import org.junit.Test;

/**
 * Created by Mauricio on 7/18/2016.
 */
public class TrialDivisionTest {

    @Test
    public void compareTests() throws Exception {
        for (int i = 0; i < 2500; i++) {
            if (MillerRabin.isPrime(i, 3) != TrialDivision.isPrime(i)) {
                System.out.println(i + " " + MillerRabin.isPrime(i, 3));
            }
        }
    }

    @Test
    public void trTest() {
        for (int i = 0; i < 100; i++) {
            System.out.println(i + " is " + TrialDivision.isPrime(i));
        }
    }
    @Test
    public void trFactors(){
        for (int i = 2; i < 50; i++) {
            int k=2*i+1;
            System.out.println(k+"has a factor"+TrialDivision.aFactor(k));
        }
    }
}