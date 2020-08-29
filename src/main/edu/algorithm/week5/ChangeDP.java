package main.edu.algorithm.week5;

import java.util.Scanner;

public class ChangeDP {
    private static int getChange(int money, int[] denominations) {
        return money / 4;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int money = scanner.nextInt();
        int[] denominations = {1, 3, 4};
        System.out.println(getChange(money, denominations));
    }
}

