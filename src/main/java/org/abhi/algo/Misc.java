package org.abhi.algo;

import java.util.Stack;

public class Misc {

    public static String integerToBinaryString(int number) {
        Stack<Integer> integerStack = new Stack<>();
        while (number > 0) {
            integerStack.push(number % 2);
            number = number / 2;
        }
        String binaryString = "";
        while (!integerStack.isEmpty()) {
            binaryString = binaryString + integerStack.pop();
        }
        return binaryString;
    }
}
