package Misc;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

public class Montcarol {
    public static void main(String[] args) {
        System.out.println(probability(ans(10000000)));
    }

    public static int[][] ans(int num) {
        Random rand = new Random();
        int[][] ans = new int[num][4];

        // Fill the array with random 0s and 1s
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < 4; j++) {
                ans[i][j] = rand.nextInt(2);
            }
        }
        // Filter rows where all elements are not zero
        return Arrays.stream(ans)
                .filter(row -> !allZero(row)) // Use the `allZero` helper function
                .toArray(int[][]::new);
    }

    private static boolean allZero(int[] row) {
        for (int value : row) {
            if (value != 0) {
                return false; // Return false if any element is not zero
            }
        }
        return true;
    }

    public static boolean guess(int[] ans) {
        Random rand = new Random();
        int[] guess = new int[4];
        for (int i = 0; i < 4; i++) {
            guess[i] = rand.nextInt(2);
        }
        return Arrays.equals(ans, guess);
    }

    public static double probability(int[][] ans) {
        int size = ans.length;
        int correct = 0;
        for (int i = 0; i < size; i++) {
            if (guess(ans[i])) {
                correct++;
            }
        }
        return (double) correct / size;
    }
}
