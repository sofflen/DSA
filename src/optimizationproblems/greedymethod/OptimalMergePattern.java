package optimizationproblems.greedymethod;

import utility.Utilities;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class OptimalMergePattern {
    public static void main(String[] args) {
        OptimalMergePattern mergePattern = new OptimalMergePattern();

        int[] arr1 = mergePattern.generateArray(5, 30);
        int[] arr2 = mergePattern.generateArray(5, 30);
        int[] arr3 = mergePattern.generateArray(5, 30);
        int[] arr4 = mergePattern.generateArray(5, 30);

        int[] result;
        result = mergePattern.mergePriorityQueue(arr1, arr2, arr3, arr4);
        Utilities.printIntArray(result);
    }

    public int[] mergePriorityQueue(int[]... arrays) {
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(array -> array.length));

        for (int[] array : arrays) {
            Arrays.sort(array);
        }

        pq.addAll(Arrays.asList(arrays));
        int[] result = new int[]{};
        while (pq.size() >= 2) {
            result = doMerge(pq.poll(), pq.poll());
            pq.add(result);
        }
        return result;
    }

    private int[] doMerge(int[] arr1, int[] arr2) {
        int leftSize = arr1.length;
        int rightSize = arr2.length;
        int[] result = new int[leftSize + rightSize];
        int leftIndex = 0;
        int rightIndex = 0;
        int mainIndex = 0;

        while (leftIndex < leftSize && rightIndex < rightSize) {
            if (arr1[leftIndex] < arr2[rightIndex]) {
                result[mainIndex++] = arr1[leftIndex++];
            } else {
                result[mainIndex++] = arr2[rightIndex++];
            }
        }

        while (leftIndex < leftSize) {
            result[mainIndex++] = arr1[leftIndex++];
        }

        while (rightIndex < rightSize) {
            result[mainIndex++] = arr2[rightIndex++];
        }
        return result;
    }

    int[] generateArray(int minSize, int maxSize) {
        Random random = new Random();
        int arraySize = random.nextInt(maxSize - minSize + 1) + minSize;
        int[] result = new int[arraySize];

        for (int i = 0; i < arraySize; i++) {
            result[i] = random.nextInt(60) + 1;
        }
        return result;
    }
}
