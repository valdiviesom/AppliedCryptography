package Encryption.PublicKey;

import PrimalityTest.PrimalityTest;
import ToolKit.Calc;
import ToolKit.Generator;

/**
 * Created by Mauricio on 7/20/2016.
 */
public class RSA {
    private int publicKey;
    private int publicMod;
    private int privateKey;

    public RSA() {
        generateKeys(7);
    }

    public RSA(int primeSize) {
        generateKeys(primeSize);
    }

    private void generateKeys(int size) {
        if (size > 7) size = 7;
        int p, q;
        do {
            p = Generator.primeOfDigits(size);
            q = Generator.primeOfDigits(size);
        } while (p == q);
        int n = p * q;
        int phiN = (p - 1) * (q - 1);
        int e;
        do {
            e = Generator.rand(2, phiN - 1);
        } while (Calc.gcd(e, phiN) > 1);
        int d = Calc.inverse(e, phiN);
        //assert (1 == Calc.mod(e * d, phiN));
        publicKey = e;
        publicMod = n;
        privateKey = d;
    }

    public int encrypt(int m) {
        m = Calc.mod(m, publicMod);
        return Calc.modularExp(m, publicKey, publicMod);
    }

    public int decrypt(int c) {
        return Calc.modularExp(c, privateKey, publicMod);
    }

    public int getPublicKey() {
        return publicKey;
    }

    public int getPublicMod() {
        return publicMod;
    }

}
