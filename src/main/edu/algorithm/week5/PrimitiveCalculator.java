package main.edu.algorithm.week5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PrimitiveCalculator {
    private static List<Integer> optimal_sequence(int n) {
        List<Integer> sequence = new ArrayList<>();

        ArrayList<OperationPair<Integer, Integer>> minOperations = new ArrayList<>();
        minOperations.add(new OperationPair<>(Integer.MAX_VALUE, null));
        minOperations.add(new OperationPair<>(0, 2));

        for (int i = 2; i <= n; i++) {
            int[] operations = new int[3];
            operations[0] = i % 2 == 0 ? i / 2 : 0; //op 0
            operations[1] = i % 3 == 0 ? i / 3 : 0; //op 1
            operations[2] = i - 1;          //op 2

            OperationPair<Integer, Integer> minimum = null;
            for (int j = 0; j < operations.length; j++) {
                if (operations[j] > 0) {
                    //save last minimum solution
                    if (minimum == null || minOperations.get(operations[j]).a + 1 < minimum.a) {
                        minimum = new OperationPair<>(minOperations.get(operations[j]).a + 1, j);
                    }
                }
            }
            minOperations.add(minimum);
        }

        while (n >= 1) {
            OperationPair<Integer, Integer> current = minOperations.get(n);
            sequence.add(n);
            switch (current.b) {
                // op 0
                case 0 -> n = n / 2;
                // op 1
                case 1 -> n = n / 3;
                // op 2
                case 2 -> n = n - 1;
            }

        }
        
        Collections.reverse(sequence);
        return sequence;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> sequence = optimal_sequence(n);
        System.out.println(sequence.size() - 1);
        for (Integer x : sequence) {
            System.out.print(x + " ");
        }
    }

    private static class OperationPair<A, B> {

        A a;
        B b;

        public OperationPair(A a, B b) {
            this.a = a;
            this.b = b;
        }
    }
}

