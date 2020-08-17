package main.edu.algorithm.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.StringTokenizer;

public class Sorting {
    private static final Random random = new Random();

    private static int[] partition3(int[] a, int l, int r) {
        int m1 = l; // part less than pivot
        int i = l;
        int m2 = r; // part grater than pivot
        int pivot = a[l];
        while (i<=m2) {
            if (a[i] < pivot) {
                swap(a, m1, i);
                m1++;
                i++;
            } else if (a[i] > pivot) {
                swap(a, m2, i);
                m2--;
            } else {
                i++;
            }
        }
        return new int[]{m1, m2};
    }

    private static void swap(int[] a, int x, int y){
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }

    private static int partition2(int[] a, int l, int r) {
        int x = a[l];
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (a[i] <= x) {
                j++;
                swap(a, i, j);
            }
        }
        swap(a, l, j);
        return j;
    }

    private static void randomizedQuickSort(int[] a, int l, int r) {
        if (l >= r) {
            return;
        }
        int k = random.nextInt(r - l + 1) + l;
        int t = a[l];
        a[l] = a[k];
        a[k] = t;
        //use partition3
//        int m = partition2(a, l, r);
        int[] m1m2 = partition3(a, l, r);
        randomizedQuickSort(a, l, m1m2[0] - 1);
        randomizedQuickSort(a, m1m2[1] + 1, r);
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        randomizedQuickSort(a, 0, n - 1);
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
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

