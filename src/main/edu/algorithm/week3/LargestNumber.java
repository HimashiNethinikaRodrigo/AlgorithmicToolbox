package main.edu.algorithm.week3;

import java.util.*;

public class LargestNumber {
    private static boolean isGreaterOrEqual(String first, int second){
        int num1 = Integer.parseInt(first+second);
        int num2 = Integer.parseInt(second+first);
        return num1>=num2;
    }
    private static String largestNumber(List<String> a) {
        String result = "";
        while (a.size()>0){
            if (a.size()==1) {
                result += a.get(0);
                a.remove(0);
                break;
            }
            int maxDigit = Integer.parseInt(a.get(0));
            int index = 0;
            for (int i = 1; i < a.size(); i++) {
                if (isGreaterOrEqual(a.get(i),maxDigit)) {
                    maxDigit = Integer.parseInt(a.get(i));
                    index = i;
                }
            }

            result+=(Integer.toString(maxDigit));
            if (index<=a.size()-1)
                a.remove(index);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<String> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            a.add(scanner.next());
        }
        System.out.println(largestNumber(a));
    }
}

