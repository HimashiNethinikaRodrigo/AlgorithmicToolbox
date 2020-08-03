//package main.edu.algorithm.week2;

import java.util.*;

public class LCM {
  private static long lcm_naive(int a, int b) {
    for (long l = 1; l <= (long) a * b; ++l)
      if (l % a == 0 && l % b == 0)
        return l;

    return (long) a * b;
  }
  private static long gcd(int a, int b) {
    if (a==0 || b==0)
      return a+b;
    int largerValue = Math.max(a,b);
    int smallerValue = Math.min(a,b);
    return gcd(largerValue%smallerValue, smallerValue);
  }

  private static long lcm_fast(int a, int b) {
    return ((long)a*b)/gcd(a,b);
  }
  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

//    System.out.println(lcm_naive(a, b));
    System.out.println(lcm_fast(a, b));

  }
}
