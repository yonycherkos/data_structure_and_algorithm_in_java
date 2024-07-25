package excercise;

import java.util.*;

public class HackerRank {
    /*
     * Given a square matrix, calculate the absolute difference
     * between the sums of its diagonals.
     */
    public static int diagonalDifference(List<List<Integer>> arr) {
        Integer sum1 = 0;
        Integer sum2 = 0;
        int i = 0;
        int n = arr.size() - 1;
        while (i <= n) {
            sum1 += arr.get(i).get(i);
            sum2 += arr.get(i).get(n - i);
            i++;
        }

        return Math.abs(sum1 - sum2);
    }

    /*
     * Given an array of integers, calculate the ratios of its elements that are
     * positive, negative, and zero. Print the decimal value of each fraction on
     * a new line with places after the decimal.
     */
    public static void plusMinus(List<Integer> arr) {
        int posCount = 0;
        int negCount = 0;
        int zeroCount = 0;
        for (int num : arr) {
            if (num > 0) {
                posCount++;
            } else if (num < 0) {
                negCount++;
            } else {
                zeroCount++;
            }
        }

        System.out.println(String.format("%.6f", (double) posCount / arr.size()));
        System.out.println(String.format("%.6f", (double) negCount / arr.size()));
        System.out.println(String.format("%.6f", (double) zeroCount / arr.size()));
    }

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(1, 1, 0, -1, -1);
        plusMinus(arr);
    }
}
