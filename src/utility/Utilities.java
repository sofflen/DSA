package utility;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Utilities {

    private Utilities() {}

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
}
