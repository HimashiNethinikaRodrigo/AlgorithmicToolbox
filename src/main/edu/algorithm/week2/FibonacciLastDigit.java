package main.edu.algorithm.week2;

import java.util.*;

public class FibonacciLastDigit {
    private static int getFibonacciLastDigitNaive(int n) {
        if (n <= 1)
            return n;

        int previous = 0;
        int current = 1;

        for (int i = 0; i < n - 1; ++i) {
            int tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
        }

        return current % 10;
    }
    private static int getFibonacciLastDigitFast(int n) {
        if (n <= 1)
            return n;
        int lastDigits[] = new int[n+1];
        lastDigits[0] = 0;
        lastDigits[1] = 1;
        for (int i = 2; i <= n ; i++) {
            lastDigits[i] = (lastDigits[i-1]+lastDigits[i-2]) % 10;
        }
        return lastDigits[n];
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
//        int c = getFibonacciLastDigitNaive(n);
        int c = getFibonacciLastDigitFast(n);
        System.out.println(c);
    }
}

