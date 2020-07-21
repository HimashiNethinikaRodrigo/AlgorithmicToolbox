package edu.algorithm.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MaxPairwiseProductWithLessTime {
    static long getMaxPairwiseProduct(int[] numbers) {
        long largest_number;
        long second_largest;
        long max_product = 0;
        int n = numbers.length;

        if (n>1) {

            largest_number = Math.max(numbers[0], numbers[1]);
            second_largest = Math.min(numbers[0], numbers[1]);

            for (int first = 2; first < n; ++first) {
                if (numbers[first]>largest_number) {
                    second_largest = largest_number;
                    largest_number = numbers[first];
                } else if (numbers[first] > second_largest || numbers[first] == largest_number ) {
                    second_largest = numbers[first];
                }
            }

            max_product = largest_number * second_largest;
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
