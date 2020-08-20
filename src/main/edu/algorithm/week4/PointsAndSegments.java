package main.edu.algorithm.week4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class PointsAndSegments {

    private static int[] fastCountSegments(int[] starts, int[] ends, int[] points) {
        int[] cnt = new int[points.length];
        Value[] allPoints = new Value[starts.length*2+points.length];
        int j= 0;

        for (int i = 0; i < starts.length; i++)
            allPoints[j++] = new Value(starts[i], 1, i);

        for (int i = 0; i < ends.length; i++)
            allPoints[j++] = new Value(ends[i], 3, i);

        for (int i = 0; i < points.length; i++)
            allPoints[j++] = new Value(points[i], 2, i);



        Arrays.sort(allPoints, PointsAndSegments::compare);


        return cnt;
    }

    private static int[] naiveCountSegments(int[] starts, int[] ends, int[] points) {
        int[] cnt = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < starts.length; j++) {
                if (starts[j] <= points[i] && points[i] <= ends[j]) {
                    cnt[i]++;
                }
            }
        }
        return cnt;
    }

    private static int compare(Value o1, Value o2) {
        if (o1.point == o2.point)
            return Integer.compare(o1.type, o2.type);
        return Integer.compare(o1.point, o2.point);
    }

    /**
     *type
     * 1= start point
     * 3= end point
     * 2= check point
     */
    private static class Value{
        int point, type, index;
        Value(int point, int type, int index){
            this.point = point;
            this.type = type;
            this.index = index;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, m;
        n = scanner.nextInt();
        m = scanner.nextInt();
        int[] starts = new int[n];
        int[] ends = new int[n];
        int[] points = new int[m];
        for (int i = 0; i < n; i++) {
            starts[i] = scanner.nextInt();
            ends[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            points[i] = scanner.nextInt();
        }
        //use fastCountSegments
//        int[] cnt = naiveCountSegments(starts, ends, points);
        int[] cnt = fastCountSegments(starts, ends, points);
        for (int x : cnt) {
            System.out.print(x + " ");
        }
    }
}

