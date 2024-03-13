package utility;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Utilities {

    private Utilities() {
    }

    public static void printIntArray(int[] arr) {
        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println();
    }

    public static void printList(List<Object> list) {
        for (Object j : list) {
            System.out.print(j + " ");
        }
        System.out.println();
    }

    public static void swapElements(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void swapElements(List<Integer> list, int i, int j) {
        int temp = list.get(i);
        list.add(i, list.get(j));
        list.add(j, temp);
    }

    public static Map<Character, Integer> countCharsInString(String str) {
        Map<Character, Integer> countMap = new HashMap<>();

        for (char c : str.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }
        return countMap;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                if (999999 == anInt) {
                    System.out.print("INF ");
                } else {
                    System.out.print(anInt + " ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void printMatrixSkipZeroRowAndColumn(int[][] matrix) {
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (999999 == matrix[i][j]) {
                    System.out.print("INF ");
                } else {
                    System.out.print(matrix[i][j] + " ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
