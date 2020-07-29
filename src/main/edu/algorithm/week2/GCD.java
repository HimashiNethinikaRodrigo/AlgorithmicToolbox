package main.edu.algorithm.week2;

import java.util.Scanner;

public class GCD {
    private static int gcd_naive(int a, int b) {
        int current_gcd = 1;
        for (int d = 2; d <= a && d <= b; ++d) {
            if (a % d == 0 && b % d == 0) {
                if (d > current_gcd) {
                    current_gcd = d;
                }
            }
        }

        return current_gcd;
    }

    private static int gcd_naive_fast(int a, int b) {
        if (b == 0)
            return a;
        return gcd_naive_fast(b, a % b);
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        System.out.println(gcd_naive(a, b));
        System.out.println(gcd_naive_fast(a, b));

    }
}
