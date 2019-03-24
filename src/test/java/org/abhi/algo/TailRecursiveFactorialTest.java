package org.abhi.algo;

import org.junit.Test;

import static org.junit.Assert.*;

public class TailRecursiveFactorialTest {

    @Test
    public void calculateFactorial() {
        assertEquals(720, TailRecursiveFactorial.calculateFactorial(6).intValue());
    }
}