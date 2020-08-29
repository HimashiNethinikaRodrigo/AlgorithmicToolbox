package main.edu.algorithm.week5;

import java.util.Scanner;

public class ChangeDP {
    private static int getChange(int money, int[] denominations) {
        int[] coinsArray = new int[money+1];
        coinsArray[0] = 0;
        for (int i = 1; i <= money; i++) {
            coinsArray[i] = Integer.MAX_VALUE;
            for (int denomination : denominations) {
                if (i >= denomination) {
                    int coins = coinsArray[i - denomination] + 1;
                    if (coins < coinsArray[i]) {
                        coinsArray[i] = coins;
                    }
                }
            }
        }
        return coinsArray[money];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int money = scanner.nextInt();
        int[] denominations = {1, 3, 4};
        System.out.println(getChange(money, denominations));
    }
}

