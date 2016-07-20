package Encryption.Tests;

import Encryption.PublicKey.RSA;
import ToolKit.Generator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Mauricio on 7/20/2016.
 */
public class RSATest {
    RSA rsa;

    @Before
    public void setUp() throws Exception {
        rsa = new RSA(3);
        System.out.println("Encryptor Created: Public Key is (" + rsa.getPublicMod() + " , " + rsa.getPublicKey() + ")");
    }

    @Test
    public void testEncrypt() throws Exception {
        int m,c,m2;
        for (int i = 0; i < 10; i++) {
            m= Generator.rand(0,rsa.getPublicMod()-1);
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