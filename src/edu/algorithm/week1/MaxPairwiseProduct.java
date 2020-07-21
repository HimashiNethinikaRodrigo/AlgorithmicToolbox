package edu.algorithm.week1;

import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.io.*;

public class MaxPairwiseProduct {
    static long getMaxPairwiseProduct(int[] numbers) {
        long max_product = 0;
        int n = numbers.length;

        for (int first = 0; first < n; ++first) {
            for (int second = first + 1; second < n; ++second) {
                long firstNum = numbers[first];
                long secondNum = numbers[second];
                max_product = Math.max(max_product, firstNum * secondNum );
            }
        }

        return max_product;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }

        System.out.println(getMaxPairwiseProduct(numbers));

        /* This code snippet is used to test the time needed to run the program

        int [] numbers = new int[100000];
        Instant start = Instant.now();
        System.out.println(getMaxPairwiseProduct(numbers));
        Instant end = Instant.now();
        System.out.println(Duration.between(end,start)); // PT-18.426949S

        */

    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new
                    InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

}
