package optimizationproblems.greedymethod;

import utility.KnapsackItem;

import java.util.*;
import java.util.stream.Collectors;

public class Knapsack {
    public static void main(String[] args) {
        Knapsack knapsack = new Knapsack();
        List<KnapsackItem> knapsackItemList = knapsack.generateList();
        System.out.println(knapsackItemList);

        System.out.println(knapsack.findBestKnapsackValue(knapsackItemList, 15d));
    }

    Map<Double, Double> findBestKnapsackValue(List<KnapsackItem> items, double maxWeight) {
        Map<Double, Double> result = new HashMap<>();
        double currentWeight = 0d;
        double value = 0d;
        items = items.stream().sorted((k1, k2) -> Double.compare(((double) k2.getValue() / k2.getWeight()),
                ((double) k1.getValue() / k1.getWeight()))).collect(Collectors.toList());

        for (KnapsackItem item : items) {
            if (currentWeight >= maxWeight) {
                result.put(currentWeight, value);
                return result;
            }
            if (currentWeight + item.getWeight() <= maxWeight) {
                currentWeight += item.getWeight();
                value += item.getValue();
            } else {
                double requiredItemWeight = maxWeight - currentWeight;
                value += ((double) item.getValue() / item.getWeight()) * requiredItemWeight;
                currentWeight += requiredItemWeight;
            }
        }
        return result;
    }
    private List<KnapsackItem> generateList() {
        List<KnapsackItem> result = new ArrayList<>();
        Random random = new Random();

        int minAmount = 5;
        int maxAmount = 20;
        int amountOfItems = random.nextInt(maxAmount - minAmount + 1) + minAmount;

        for (int i = 0; i < amountOfItems; i++) {
            KnapsackItem item = new KnapsackItem(random.nextInt(30) + 1, random.nextInt(30) + 1);
            result.add(item);
        }
        return result;
    }
}
