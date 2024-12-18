package IndependentProblemSets;

import java.util.Arrays;

public class Knapsack {
    static int naive(int n, int[] v, int[] w, int c) {
        if (n == 0) {return 0;}     // take nothing, get 0 point
        if (w[n-1] > c) {           // if the nth item is heavier than remaining capacity,
            return naive(n-1, v, w, c); // choose to not take the nth item
        }
        // if the nth item is taken, compare the eventual total point if
        return Math.max(naive(n-1, v,w,c), // not taking the nth item, OR
                (v[n-1] + naive(n-1,v,w,c-w[n-1]))); // take the nth item
    }
    // memoize the partial solutions:
    static int memoized(int n, int[] v, int[] w, int c) {
        int[][] memo = new int[n][c];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < c; j++) {
                memo[i][j] = -1;
            }
        }
        if (n == 0) {return 0;}
        if (w[n-1] > c) {
            if (memo[n-2][c-1]!=-1) {
                return memo[n - 2][c - 1];
            } else {
                memo[n-2][c-1] = memoized(n-1, v, w, c);
                return memo[n - 2][c - 1];
            }
        }
        int take, notTake;
        if (memo[n-2][c-1]!=-1) {
            notTake = memo[n - 2][c - 1];
        } else {
            memo[n-2][c-1] = memoized(n-1, v, w, c);
            notTake = memo[n - 2][c - 1];
        }
        if (memo[n-2][c-1-w[n-1]]!=-1) {
            take = memo[n - 2][c - 1-w[n-1]];
        } else {
            memo[n-2][c-1] = memoized(n-1, v, w, c);
            take = memo[n - 2][c - 1-w[n-1]];
        }
        return Math.max(take, notTake);
    }
    public static void main(String[] args) {
        int[] v = {7, 9, 5, 12, 14, 6, 12};
        int[] w = {3, 4, 2, 6, 7, 3, 5};
        int n = 7;
        int c = 15;
        System.out.println(memoized(n,v,w,c));
    }
}
