package FactoringAlgorithms.Tests;

import FactoringAlgorithms.PerfectPower;
import ToolKit.Generator;
import ToolKit.Calc;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Mauricio on 7/19/2016.
 */
public class PerfectPowerTest {

    @Test
    public void testIsPerfect() throws Exception {
        assertTrue(PerfectPower.isPerfect(27));
        assertTrue(PerfectPower.isPerfect(125));
        assertTrue(PerfectPower.isPerfect(Calc.power(7, 3)));
        assertFalse(PerfectPower.isPerfect(28));
        int base, exp, offset,n;
        for (int i = 0; i < 150; i++) {
            base = Generator.rand(2, 7);
            exp = Generator.rand(2,7);
            offset=Generator.rand(15,30);
            n= Calc.power(base,exp)+offset;
            boolean perfect = PerfectPower.isPerfect(n);
            if(offset==0){
                //System.out.println(n+"="+base+"^"+exp+"+"+offset);
                assertTrue(perfect);
            }
            else {
                System.out.println(n+"="+base+"^"+exp+"+"+offset);
                assertFalse(perfect);
            }
        }
    }

}