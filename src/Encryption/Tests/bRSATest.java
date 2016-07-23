package Encryption.Tests;

import Encryption.PublicKey.BigRSA;
import Encryption.PublicKey.RSA;
import ToolKit.Generator;
import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;

/**
 * Created by Mauricio on 7/20/2016.
 */
public class bRSATest {
    BigRSA rsa;

    @Before
    public void setUp() throws Exception {
        rsa = new BigRSA(22);
        System.out.println("Encryptor Created: Public Key is (" + rsa.getPublicMod() + " , " + rsa.getPublicKey() + ")");
    }

    @Test
    public void testEncrypt() throws Exception {
        int m,m2;
        BigInteger c;
        for (int i = 0; i < 10; i++) {
            m= Generator.rand(0,255);
            c=rsa.encrypt(m);
            m2=rsa.decrypt(c);
            System.out.println("sending " + m + " as " + c+" receiving as "+m2);
            //assertEquals(m,m2);
        }
    }

    @Test
    public void testDecrypt() throws Exception {

    }
}