package main.edu.algorithm.week2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Fibonacci {
  static Map <Long, Long> map = new HashMap<>();
  public static long calc_fib(long n) {
    if (n <= 1)
      return n;
    if (map.containsKey(n))
      return map.get(n);
    map.put(n, (calc_fib(n - 1) + calc_fib(n - 2)));
    return calc_fib(n - 1) + calc_fib(n - 2);
  }

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    long n = in.nextLong();

    System.out.println(calc_fib(n));
  }
}
