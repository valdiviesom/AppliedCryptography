package Encryption.PublicKey;

import java.math.BigInteger;
import java.util.Random;

/**
 * Created by Mauricio on 7/20/2016.
 */
public class BigRSA {
    private BigInteger publicKey;
    private BigInteger publicMod;
    private BigInteger privateKey;

    public BigRSA(int primeSize) {
        generateKeys(primeSize);
    }

    private void generateKeys(int size) {
        BigInteger p, q;
        Random random = new Random();
        do {
            p = BigInteger.probablePrime(size, random); //todo: implement probablePrime with MillerRabin
            q = BigInteger.probablePrime(size, random);
        } while (p.compareTo(q) == 0);
        BigInteger n = p.multiply(q);
        BigInteger t1 = p.subtract(BigInteger.ONE);
        BigInteger t2 = q.subtract(BigInteger.ONE);
        BigInteger phiN = t2.multiply(t1);
        BigInteger e;
        do {
            e = new BigInteger(phiN.bitLength(), random);
        }
        while ((e.compareTo(BigInteger.ONE) == 0) ||
                (e.compareTo(phiN) == 1) || (e.gcd(phiN).compareTo(BigInteger.ONE) == 1));
        BigInteger d = e.modInverse(phiN);
        //assert (1 == Calc.mod(e * d, phiN));
        publicKey = e;
        publicMod = n;
        privateKey = d;
    }

    public static BigInteger encrypt(int m, BigInteger publicKey, BigInteger publicMod) {
        if (m < 0) m = -m;
        return BigInteger.valueOf(m).modPow(publicKey, publicMod);
    }

    public BigInteger encrypt(int m) {
        return encrypt(m, publicKey, publicMod);
    }

    public int decrypt(BigInteger c) {
        return decrypt(c, privateKey, publicMod);
    }

    public static int decrypt(BigInteger c, BigInteger privateKey, BigInteger publicMod) {
        return c.modPow(privateKey, publicMod).intValue();
    }

    public BigInteger getPublicKey() {
        return publicKey;
    }

    public BigInteger getPublicMod() {
        return publicMod;
    }

}
