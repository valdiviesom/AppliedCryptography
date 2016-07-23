package Encryption.Tests;

import Encryption.BlockCipher;
import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;
import java.sql.Time;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Mauricio on 7/21/2016.
 */
public class BlockCipherTest {
    BlockCipher blockCipher;

    @Before
    public void setUp() throws Exception {
        blockCipher = new BlockCipher(1024);
    }

    @Test
    public void testEncrypt() throws Exception {
        String message = "hello world! !@#$%^&*()_+;;;;ñ";
        long start = System.currentTimeMillis();
        List<BigInteger> cipherText = blockCipher.encrypt(message);
        long etime = System.currentTimeMillis();
        System.out.println((double) ((double)(etime-start)/1000));
        //System.out.println(cipherText);
        String m2 = blockCipher.decrypt(cipherText);
        System.out.println(m2);
    }
}