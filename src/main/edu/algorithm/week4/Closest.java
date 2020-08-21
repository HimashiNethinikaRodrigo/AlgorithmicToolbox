package main.edu.algorithm.week4;

import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class Closest {

    static class Point implements Comparable<Point> {
        long x, y;

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            return o.y == y ? Long.signum(x - o.x) : Long.signum(y - o.y);
        }
    }

    static double calculateDistance(Point p1,Point p2){
        return pow(pow(p1.x - p2.x, 2)+ pow(p1.y - p2.y, 2), 0.5);
    }

    static double minimalDistance(Point[] x, Point[] y){
        double ans = Double.POSITIVE_INFINITY;
        if (x.length == 1)
            return ans;
        if(x.length == 2)
            return calculateDistance(x[0], x[1]);
        return ans;
    }


    static void minimalDistance(int[] x, int y[]) {
        Point[] allPoints = new Point[x.length];
        for (int i = 0; i < x.length; i++) {
            allPoints[i]= new Point(x[i], y[i]);
        }
        Arrays.sort(allPoints);

    }

    public static void main(String[] args) throws Exception {
        reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new PrintWriter(System.out);
        int n = nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = nextInt();
            y[i] = nextInt();
        }
        minimalDistance(x, y);
//        System.out.println(minimalDistance(x, y));
        writer.close();
    }

    static BufferedReader reader;
    static PrintWriter writer;
    static StringTokenizer tok = new StringTokenizer("");


    static String next() {
        while (!tok.hasMoreTokens()) {
            String w = null;
            try {
                w = reader.readLine();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (w == null)
                return null;
            tok = new StringTokenizer(w);
        }
        return tok.nextToken();
    }

    static int nextInt() {
        return Integer.parseInt(next());
    }
}
