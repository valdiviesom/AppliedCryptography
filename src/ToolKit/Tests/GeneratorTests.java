package ToolKit.Tests;

import FactoringAlgorithms.PerfectPower;
import ToolKit.Generator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * Created by Mauricio on 7/18/2016.
 */
public class GeneratorTests {

    @Test
    public void testRand() throws Exception {
        for (int i = 0; i < 10; i++) {
            int x = Generator.rand(10, 110);
            System.out.println(x);
        }
    }


}