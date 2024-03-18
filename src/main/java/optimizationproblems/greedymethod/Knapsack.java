package optimizationproblems.greedymethod;

import utility.KnapsackItem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static utility.Utilities.generateKnapsackItemsList;

public class Knapsack {
    public static void main(String[] args) {
        Knapsack knapsack = new Knapsack();
        List<KnapsackItem> knapsackItemList = generateKnapsackItemsList(5, 20, 30, 30);
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
}
