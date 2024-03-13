package sorts;

import java.util.Arrays;

import static utility.Utilities.printIntArray;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 27, 8, 7, 31, 4, 14, 51, 32, 16, 9};
        printIntArray(arr);

        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(arr, 0, arr.length - 1);

        System.out.println("sorts.MergeSort array:");
        printIntArray(arr);
    }

    private void sort(int[] arr, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }
        int midIndex = (startIndex + endIndex) / 2;
        sort(arr, startIndex, midIndex);
        sort(arr, midIndex + 1, endIndex);
        merge(arr, startIndex, midIndex, endIndex);

    }

    private void merge(int[] arr, int startIndex, int midIndex, int endIndex) {
        int[] leftPart = Arrays.copyOfRange(arr, startIndex, midIndex + 1);
        int[] rightPart = Arrays.copyOfRange(arr, midIndex + 1, endIndex + 1);
        int leftSize = leftPart.length;
        int rightSize = rightPart.length;
        int leftIndex = 0;
        int rightIndex = 0;
        int mainIndex = startIndex;

        while (leftIndex < leftSize && rightIndex < rightSize) {
            if (leftPart[leftIndex] < rightPart[rightIndex]) {
                arr[mainIndex++] = leftPart[leftIndex++];
            } else {
                arr[mainIndex++] = rightPart[rightIndex++];
            }
        }

        while (leftIndex < leftSize) {
            arr[mainIndex++] = leftPart[leftIndex++];
        }

        while (rightIndex < rightSize) {
            arr[mainIndex++] = rightPart[rightIndex++];
        }
    }
}
