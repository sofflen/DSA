package optimizationproblems.dynamicprogramming;

public class MatrixChainMultiplication {
    public static void main(String[] args) {
        MatrixChainMultiplication mcm = new MatrixChainMultiplication();
        String result = mcm.calculateOrderOfMultiplication(new int[5][4], new int[4][6], new int[6][2], new int[2][7]);
        System.out.println("Order of matrices chain multiplication is\n" + result);

    }

    public String calculateOrderOfMultiplication(int[][]... matrices) {
        if (!isPossibleToMultiply(matrices)) {
            System.out.println("ERROR: Matrices cannot be multiplied!");
            return null;
        }
        int size = matrices.length + 1;
        int[] dimensions = findDimensions(matrices);
        int[][] multiplications = new int[size][size];
        int[][] split = new int[size][size];

        int column;
        int min;
        int multiplicationAmount;

        for (int d = 1; d < size - 1; d++) {
            for (int row = 1; row < size - d; row++) {
                column = row + d;
                min = 99999;
                for (int k = row; k <= column - 1; k++) {
                    multiplicationAmount = multiplications[row][k] + multiplications[k + 1][column]
                            + dimensions[row - 1] * dimensions[k] * dimensions[column];
                    if (multiplicationAmount < min) {
                        min = multiplicationAmount;
                        split[row][column] = k;
                    }
                }
                multiplications[row][column] = min;
            }
        }

        StringBuilder optimalParentheses = new StringBuilder();
        findOptimalParentheses(split, 1, matrices.length, optimalParentheses);
        return optimalParentheses.substring(0, optimalParentheses.length()-1);
    }

    private void findOptimalParentheses(int[][] split, int row, int column, StringBuilder sb) {
        if (row == column) {
            sb.append("A").append(row);
        } else {
            if (!sb.toString().endsWith("(")) {
                sb.append("(");
            }
            int splitValue = split[row][column];
            findOptimalParentheses(split, row, splitValue, sb);
            findOptimalParentheses(split, splitValue + 1, column, sb);
            sb.append(")");
        }
    }


    private boolean isPossibleToMultiply(int[][]... matrices) {
        for (int i = 0; i < matrices.length - 1; i++) {
            if (matrices[i][0].length != matrices[i + 1].length) {
                return false;
            }
        }
        return true;
    }

    private int[] findDimensions(int[][]... matrices) {
        int length = matrices.length;
        int[] result = new int[length + 1];
        for (int i = 0; i < length; i++) {
            result[i] = matrices[i].length;
        }
        result[length] = matrices[length - 1][0].length;
        return result;
    }
}
