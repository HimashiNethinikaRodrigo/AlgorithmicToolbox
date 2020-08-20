package main.edu.algorithm.week4;

import java.util.Scanner;

public class Inversions {

    private static long getNumberOfInversions(int[] a, int[] b, int left, int right) {
        long numberOfInversions = 0;
        if (right > left) {
            int mid = (right + left) / 2;
            numberOfInversions += getNumberOfInversions(a, b, left, mid);
            numberOfInversions += getNumberOfInversions(a, b, mid + 1, right);
            numberOfInversions += mergeAndCountInversions(a, b, left, mid, right);
        }
        return numberOfInversions;
    }

    private static int mergeAndCountInversions(int[] a, int[] b, int left, int mid, int right) {
        int inversions = 0;

        int i = left, j = mid + 1, k = left;

        while (i <= mid && j <= right) {
            if (a[i] <= a[j]) {
                b[k++] = a[i++];
            } else {
                b[k++] = a[j++];
                inversions += mid - i + 1;
            }
        }
        while (i <= mid)
            b[k++] = a[i++];


        while (j <= right)
            b[k++] = a[j++];


        if (right + 1 - left >= 0) System.arraycopy(b, left, a, left, right + 1 - left);


        return inversions;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int[] b = new int[n];
        System.out.println(getNumberOfInversions(a, b, 0, a.length - 1));
    }
}

