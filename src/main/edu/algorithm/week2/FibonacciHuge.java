package main.edu.algorithm.week2;

import java.util.*;

public class FibonacciHuge {
    private static long getFibonacciHugeNaive(long n, long m) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
        }

        return current % m;
    }

    private static int getPisanoPeriod(int m) {
        if (m==1)
            return 0;
        int previous =0;
        int current = 1;
        for (int i = 0; i < m * m; i++) {
            int originalPrevious = previous;
            previous = current;
            current = (originalPrevious + current) % m;

            if (previous == 0 && current==1)
                return i+1;
        }
        return m;
    }
    private static int getFibonacciModulusFast(int n, int m) {
        if (n <= 1)
            return n;
        int lastDigits[] = new int[n+1];
        lastDigits[0] = 0;
        lastDigits[1] = 1;
        for (int i = 2; i <= n ; i++) {
            lastDigits[i] = (lastDigits[i-1]+lastDigits[i-2]) % m;
        }
        return lastDigits[n];
    }
    public static long getFibonacciHugeFast(long n, int m) {
        int pisanoLength = getPisanoPeriod(m);
        n = n % pisanoLength;
        return getFibonacciModulusFast((int)n,m);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        int m = scanner.nextInt();
        System.out.println(getFibonacciHugeFast(n, m));
    }
}

