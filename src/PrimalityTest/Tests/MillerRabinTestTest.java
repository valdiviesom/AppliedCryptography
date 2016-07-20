package PrimalityTest.Tests;

import PrimalityTest.MillerRabin;
import FactoringAlgorithms.TrialDivision;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Mauricio on 7/18/2016.
 */
public class MillerRabinTestTest {
    @org.junit.Test
    public void testIsPrime() throws Exception {
        for (int i = 0; i < 2500; i++) {
            System.out.println(i + " is " + MillerRabin.isPrime(i, 3));
        }
    }

    @Test
    public void MillerVsTrial() {
        int c=0;
        for (int i = 3; i < 500; i++) {
            boolean p = MillerRabin.isPrime(i, 5);
            if (p != TrialDivision.isPrime(i)) {
                c++;
                System.out.println(i + " is " + p);
            }
        }
        System.out.println("error = " + c*100/497);
    }

    @Test
    public void wikiVsTrialTest() {
        int c=0;
        for (int i = 3; i < 500; i++) {
            boolean p = MillerRabin.wiki(i, 3);
            if (p != TrialDivision.isPrime(i)) {
                c++;
                System.out.println(i + " is " + p);
            }
        }
        System.out.println("error = " + c*100/497);
    }

    @Test
    public void wikiVsMiller() {
        int c=0;
        for (int i = 3; i < 500; i++) {
            boolean p = MillerRabin.wiki(i, 3);
            if (p != MillerRabin.isPrime(i)) {
                c++;
                System.out.println(i + " is " + p);
            }
        }
        System.out.println("error = " + c*100/497);

    }

    @Test
    public void vote() {
        for (int i = 3; i < 500; i++) {
            boolean wiki = MillerRabin.wiki(i, 5);
            boolean trial = TrialDivision.isPrime(i);
            boolean miller = MillerRabin.isPrime(i, 5);

            if (!(wiki == trial) && (trial == miller)) {
                System.out.println("i" + "= " + i + " " + "miller = " + miller + " wiki = " + wiki
                        + " trial = " + trial);
            }
        }
    }


    @org.junit.Test
    public void testFindS() throws Exception {
        for (int n = 10; n < 1000; n++) {
            int s = MillerRabin.findS(n);
            int r = (int) ((n - 1) / Math.pow(2, s));
            assertEquals(n - 1, (int) Math.pow(2, s) * r);
        }
    }
}