package main.edu.algorithm.week3.change;

import java.util.Scanner;

public class ChangeImproved {
    private static int getChange(int m) {
        int change = 0;
        int five = 5;
        int ten = 10;
        int ten_coins = m/ten;
        if (ten_coins>=1) {
            change += ten_coins;
            m -= ten*ten_coins;
        }

        int five_coins = m/five;
        if (five_coins>=1) {
            change += five_coins;
            m -= five*(five_coins);
        }
        change+=m;
        return change;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }

}
