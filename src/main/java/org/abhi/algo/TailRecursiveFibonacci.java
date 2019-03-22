package org.abhi.algo;

public class TailRecursiveFibonacci {

    public static Integer fibonacci(Integer number) {
        return fibonacciInternal(number, 0, 1);
    }

    private static Integer fibonacciInternal(Integer number, Integer current, Integer next) {
        if(number == 0) {
            return current;
        }
        else {
            return fibonacciInternal(number - 1, next, current + next);
        }
    }
}
