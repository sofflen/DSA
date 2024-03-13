package sorts;

import static utility.Utilities.printIntArray;
import static utility.Utilities.swapElements;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 27, 8, 7, 31, 4, 14, 51, 32, 16, 9};

        QuickSort qs = new QuickSort();
        qs.sort(arr, 0, arr.length - 1);

        System.out.println("quicksort array: ");
//        printIntArray(arr);
        printIntArray(arr);
    }


    void sort(int[] arr, int l, int h) {
        if (l < h) {
            //do the partition procedure: move pivot element to its sorted place
            int j = partition(arr, l, h);
            //recursively sort left subarray
            sort(arr, l, j-1);
            //recursively sort right subarray
            sort(arr, j+1, h);
        }
    }
    int partition(int[] arr, int l, int h) {
        //take the lowest element as a pivot
        int pivot = arr[l];
        int i = l;
        int j = h;

        //swap elements until i (index of element bigger than pivot)
        //crosses j (index of element smaller than pivot)
        while (i < j) {
            //find element bigger than pivot
            do {
                i++;
            } while (arr[i] <= pivot);

            //find element smaller or equal to pivot
            while (arr[j] > pivot) {
                j--;
            }

            //verify that i didn't cross j
            if (i < j) {
                //swap arr[i]>pivot and arr[j]<pivot
                swapElements(arr, i, j);
            }
        }
        //when i has crossed j, swap pivot element with j element (arr[j] < pivot && i > j)
        swapElements(arr, l, j);
        return j;
    }
}
