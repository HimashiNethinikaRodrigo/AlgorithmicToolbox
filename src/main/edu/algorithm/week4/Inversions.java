package main.edu.algorithm.week4;

import java.util.*;

public class Inversions {

    private static long getNumberOfInversions(int[] a, int[] b, int left, int right) {
        long numberOfInversions = 0;
        if (right == left ) {
            return numberOfInversions;
        }
        int ave = left + ((left - right) / 2);
        numberOfInversions += getNumberOfInversions(a, b, left, ave);
        numberOfInversions += getNumberOfInversions(a, b, ave+1, right);
        //write your code here
        numberOfInversions += mergeAndCountInversions(a, b, left, ave, right);
        return numberOfInversions;
    }

    private static int mergeAndCountInversions(int[] a, int[] b, int left, int ave, int right) {
        int[] n1 = new int[ave-left];
        int[] n2 = new int [right-ave];
        int inversions = 0;
        if (n1.length - left >= 0) System.arraycopy(a, left + left, n1, left, n1.length - left);
        if (n2.length >= 0) System.arraycopy(a, ave, n2, 0, n2.length);

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

