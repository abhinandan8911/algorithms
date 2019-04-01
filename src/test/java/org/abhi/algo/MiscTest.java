package org.abhi.algo;

import org.junit.Test;

import static org.junit.Assert.*;

public class MiscTest {

    @Test
    public void integerToBinaryString() {
        int number = 25;
        System.out.println("The binary of number : " + number + " is : " + Misc.integerToBinaryString(number));
    }
}