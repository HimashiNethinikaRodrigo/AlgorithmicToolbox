package main.edu.algorithm.week2;

import java.util.*;

public class FibonacciPartialSum {
    private static long getFibonacciPartialSumNaive(long from, long to) {
        long sum = 0;

        long current = 0;
        long next = 1;

        for (long i = 0; i <= to; ++i) {
            if (i >= from) {
                sum += current;
            }

            long new_current = next;
            next = next + current;
            current = new_current;
        }

        return sum % 10;
    }

    public static long getFibonacciPartialSumFast(long from, long to) {
        long value = (FibonacciHuge.getFibonacciHugeFast(to + 2, 10) -1)
                - (FibonacciHuge.getFibonacciHugeFast(from + 1, 10)-1);
        if (value<0)
            return (value%10+10)%10;
        return value;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long from = scanner.nextLong();
        long to = scanner.nextLong();
//        System.out.println(getFibonacciPartialSumNaive(from, to));
        System.out.println(getFibonacciPartialSumFast(from, to));

    }
}

