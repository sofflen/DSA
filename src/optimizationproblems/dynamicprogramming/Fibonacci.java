package optimizationproblems.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class Fibonacci {
    static List<Integer> fiboList = new ArrayList<>();

    static {
        fiboList.add(0);
        fiboList.add(1);
    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        System.out.println(fibonacci.classicFibonacci(5));
        System.out.println(fibonacci.memoizationFibonacci(15));
        System.out.println(fibonacci.tabulationFibonacci(15));
    }

    public int classicFibonacci(int index) {
        if (index <= 1) {
            return index;
        }
        return classicFibonacci(index - 1) + classicFibonacci(index - 2);
    }

    public int memoizationFibonacci(int index) {
        if (index <= 1) {
            return index;
        }
        if (index < fiboList.size()) {
            return fiboList.get(index);
        }
        int result = memoizationFibonacci(index - 1) + memoizationFibonacci(index - 2);
        fiboList.add(index, result);
        return result;
    }

    public int tabulationFibonacci(int index) {
        if (index <= 1) {
            return index;
        }
        int[] fiboTable = new int[index + 1];
        fiboTable[0] = 0;
        fiboTable[1] = 1;
        for (int i = 2; i <= index; i++) {
            fiboTable[i] = fiboTable[i-1] + fiboTable[i-2];
        }
        return fiboTable[index];
    }
}
