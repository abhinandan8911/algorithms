package org.abhi.algo;

import java.math.BigInteger;

public class TailRecursiveFactorial {

    private static BigInteger calculateFactorialInternal(Integer number, BigInteger result) {
        if(number == 0) {
            return result;
        }
        else {
            return calculateFactorialInternal(number - 1, result.multiply(BigInteger.valueOf(number)));
        }
    }

    public static BigInteger calculateFactorial(Integer number) {
        return calculateFactorialInternal(number, BigInteger.ONE);
    }
}
