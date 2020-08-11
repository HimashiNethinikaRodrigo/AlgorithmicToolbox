package main.edu.algorithm.week3.change;

import java.util.Scanner;

public class Change {
    private static int getChange(int m) {
        int change = 0;
        int one = 1;
        int five = 5;
        int ten = 10;
        while (m>=ten){
            m-=ten;
            change++;
        }
        while (m>=five){
            m-=five;
            change++;
        }
        while (m>=one){
            m-=one;
            change++;
        }
        return change;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

