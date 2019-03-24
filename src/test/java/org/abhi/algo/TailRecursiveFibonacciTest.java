package org.abhi.algo;

import org.junit.Test;

import static org.junit.Assert.*;

public class TailRecursiveFibonacciTest {

    @Test
    public void fibonacci() {
        assertEquals(610, TailRecursiveFibonacci.fibonacci(15).intValue());
    }
}