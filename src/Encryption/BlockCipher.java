package Encryption;

import Encryption.PublicKey.BigRSA;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Mauricio on 7/20/2016.
 */
public class BlockCipher {
    BigRSA rsa;

    public BlockCipher(int security) {
        rsa = new BigRSA(security);
    }

    public List<BigInteger> encrypt(String message) {
        List<BigInteger> rsf = new LinkedList<BigInteger>();
        int m;
        for (int i = 0; i < message.length(); i++) {
            m = (int) message.charAt(i);
            rsf.add(rsa.encrypt(m));
        }
        return rsf;
    }

    public String decrypt(List<BigInteger> ciphertext) {
        StringBuilder s = new StringBuilder();
        for (BigInteger b : ciphertext) {
            s.append((char) rsa.decrypt(b));
        }
        return s.toString();
    }


}
