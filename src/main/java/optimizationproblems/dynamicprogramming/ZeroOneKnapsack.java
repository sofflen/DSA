package optimizationproblems.dynamicprogramming;

import utility.KnapsackItem;
import utility.Utilities;

import java.util.List;

public class ZeroOneKnapsack {
    public static void main(String[] args) {
        ZeroOneKnapsack knapsack = new ZeroOneKnapsack();
        List<KnapsackItem> items = Utilities.generateKnapsackItemsList(3, 8, 10, 10);
        System.out.println(items);

        int[] result = knapsack.findBestKnapsackValue(items, 10);
        Utilities.printIntArray(result);
    }

    int[] findBestKnapsackValue(List<KnapsackItem> items, int maxWeight) {
        if (items == null || items.isEmpty()) {
            return new int[0];
        }

        if (!items.contains(new KnapsackItem(0, 0))) {
            items.add(0, new KnapsackItem(0, 0));
        }

        int listSize = items.size();
        int itemsAmount = listSize - 1;
        int[] value = new int[listSize];
        int[] weight = new int[listSize];
        int[][] table = new int[listSize][maxWeight + 1];

        for (int i = 0; i < listSize; i++) {
            value[i] = items.get(i).getValue();
            weight[i] = items.get(i).getWeight();
        }

        for (int i = 0; i <= itemsAmount; i++) {
            for (int w = 0; w <= maxWeight; w++) {
                if (i == 0 || w == 0) {
                    table[i][w] = 0;
                } else if (weight[i] <= w) {
                    table[i][w] = Math.max(value[i] + table[i - 1][w - weight[i]], table[i - 1][w]);
                } else {
                    table[i][w] = table[i - 1][w];
                }
            }
        }
        System.out.println(table[itemsAmount][maxWeight]);

        int[] result = new int[itemsAmount];
        while (itemsAmount > 0 && maxWeight > 0) {
            if (table[itemsAmount][maxWeight] != table[itemsAmount - 1][maxWeight]) {
                result[itemsAmount - 1] = 1;
                maxWeight = maxWeight - weight[itemsAmount];
            }
            itemsAmount--;
        }
        return result;
    }
}
