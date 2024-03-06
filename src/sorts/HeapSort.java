package sorts;

import static utility.Utilities.printIntArray;
import static utility.Utilities.swapElements;

public class HeapSort {

    // Driver's code
    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 27, 8, 7, 31, 4, 14, 51, 32, 16, 9};

        // Function call
        HeapSort ob = new HeapSort();
        ob.sort(arr);

        System.out.println("sorts.HeapSort array:");
        printIntArray(arr);
    }

    public void sort(int[] arr) {
        int N = arr.length;

        // Build heap (rearrange array)
        for (int i = N / 2 - 1; i >= 0; i--) {
            heapify(arr, N, i);
        }

        // One by one extract an element from heap
        for (int i = N - 1; i > 0; i--) {
            // Move current root to end
            swapElements(arr, 0, i);

            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }

    // To heapify a subtree rooted with node i which is
    // an index in arr[]. N is size of heap
    void heapify(int[] arr, int N, int i) {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < N && arr[l] > arr[largest])
            largest = l;

        // If right child is larger than largest so far
        if (r < N && arr[r] > arr[largest])
            largest = r;

        // If largest is not root
        if (largest != i) {
            swapElements(arr, i, largest);

            // Recursively heapify the affected subtree
            heapify(arr, N, largest);
        }
    }
}
