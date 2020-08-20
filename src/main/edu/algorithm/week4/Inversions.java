package main.edu.algorithm.week4;

import java.util.*;

public class Inversions {

    private static long getNumberOfInversions(int[] a, int[] b, int left, int right) {
        long numberOfInversions = 0;
        if (right == left ) {
            return numberOfInversions;
        }
        int mid = left + ((right - left) / 2);
        numberOfInversions += getNumberOfInversions(a, b, left, mid);
        numberOfInversions += getNumberOfInversions(a, b, mid+1, right);
        numberOfInversions += mergeAndCountInversions(a, b, left, mid, right);
        return numberOfInversions;
    }

    private static int mergeAndCountInversions(int[] a, int[] b, int left, int mid, int right) {
        int[] n1 = new int[mid-left];
        int[] n2 = new int [right-mid];
        int inversions = 0;
        for (int i = left; i < n1.length ; i++) {
            n1[i] = a[left+i];
        }
        for (int i = 0; i < n2.length; i++) {
            n2[i] = a[mid+i];
        }
        int i=0, j=0, k = left;

        while (i < n1.length && j < n2.length) {
            if (n1[i] <= n2[j]) {
                b[k] = n1[i];
                i++;
            } else {
                b[k] = n2[j];
                inversions++;
                j++;
            }
            k++;

            while (i < n1.length) {
                b[k] = n1[i];
                i++;
                k++;
            }

            while (j < n2.length) {
                b[k] = n2[j];
                j++;
                k++;
            }
        }
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
        System.out.println(getNumberOfInversions(a, b, 0, a.length));
    }
}

