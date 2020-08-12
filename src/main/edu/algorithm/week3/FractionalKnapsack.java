package main.edu.algorithm.week3;

import java.util.*;

public class FractionalKnapsack {

    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        double value = 0d;
        List<Item> itemList = new ArrayList<>();
        for (int i = 0; i < weights.length; i++) {
            Item item = new Item(values[i],weights[i], i);
            itemList.add(item);
        }
        Collections.sort(itemList, new SortByCost());
//        for (Item i: itemList) {
//            System.out.println(i.value + " "+ i.weight+" "+i.cost);
//        }
        for (Item item:itemList) {
            int currentWeight = (int) item.weight;
            int currentValue = (int) item.value;

            if (capacity - currentWeight >= 0)
            {
                capacity = capacity-currentWeight;
                value += currentValue;

            }
            else
            {
                double fraction = ((double)capacity/(double)currentWeight);
                value += (currentValue*fraction);
                capacity = (int)(capacity - (currentWeight*fraction));
                break;
            }

        }
        return value;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.printf("%.4f %n",getOptimalValue(capacity, values, weights));
    }
}

class Item {
    int value, weight, index;
    Double cost;

    Item(int value, int weight, int index) {
        this.value = value;
        this.weight = weight;
        this.index = index;
        this.cost = value * 1.0 / weight;
    }
}

class SortByCost implements Comparator<Item> {
    @Override
    //comparator to sort in descending order
    public int compare(Item item1, Item item2) {
        return item2.cost.compareTo(item1.cost);

    }

//    @Override
//    //comparator to sort in ascending order
//    public int compare(Item item1, Item item2) {
//        return item1.cost.compareTo(item2.cost);
//
//    }
}

