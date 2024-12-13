package IndependentProblemSets;

import java.util.PriorityQueue;
import java.util.TreeMap;

public class MarkArrayScore {
    /**
     * Input: nums = [2,1,3,4,5,2]
     * Output: 7
     * Explanation: We mark the elements as follows:
     * - 1 is the smallest unmarked element, so we mark it and its two adjacent elements: [2,1,3,4,5,2].
     * - 2 is the smallest unmarked element, so we mark it and its left adjacent element: [2,1,3,4,5,2].
     * - 4 is the only remaining unmarked element, so we mark it: [2,1,3,4,5,2].
     * Our score is 1 + 2 + 4 = 7.
     * */
    public static int findScore2(int[] arr) {
        if (arr.length == 1) {
            return arr[0];
        }
        if (arr.length == 2) {
            return Math.min(arr[0], arr[1]);
        }
        TreeMap<Integer, PriorityQueue<Integer>> map = new TreeMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], new PriorityQueue<>()); // value -> index;
            }
            map.get(arr[i]).add(i);
        }
        int score = 0;
        while (!map.isEmpty()) {
            int min = map.firstEntry().getKey();
            int minIdx = map.firstEntry().getValue().poll();
            int left = minIdx - 1;
            int right = minIdx + 1;
            if (left >= 0) {
                int leftVal = arr[left];
                if (map.containsKey(leftVal)) {
                    map.get(leftVal).remove(left);
                    if (map.get(leftVal).isEmpty()) {
                        map.remove(leftVal);
                    }
                }
            }
            if (right < arr.length) {
                int rightVal = arr[right];
                if (map.containsKey(rightVal)) {
                    map.get(rightVal).remove(right);
                    if (map.get(rightVal).isEmpty()) {
                        map.remove(rightVal);
                    }
                }
            }
            score = score + min;
            if (map.containsKey(min)) {
                if (map.get(min).isEmpty()) {
                    map.remove(min);
                }
            }
        }
        return score;
    }
    public static long findScore(int[] arr) {
        long score = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            } else {
                return Integer.compare(a[1], b[1]);
            }
        });
        for (int i = 0; i < arr.length; i++) {
            int[] pair = new int[2];
            pair[0] = arr[i];
            pair[1] = i;
            pq.add(pair);
        }
        for (int i = 0; i < arr.length; i++) {
            int[] minPair = pq.poll();
            int min = minPair[0];
            int minIdx = minPair[1];
            int leftIdx = minIdx - 1;
            int rightIdx = minIdx + 1;
            if (leftIdx >= 0) {
                int left = arr[leftIdx];
            }
            if (rightIdx < arr.length) {
                int right = arr[rightIdx];
            }
        }
        return score;
    }
    public static void main(String[] args) {
        int[] arr = {2,1,3,4,5,2};
        int[] t = {2,3,5,1,3,2};
        /**
         * 1, 1
         * 2, 0
         * 2, 5
         * 3, 2
         * 4, 3
         * 5, 4
         *
         * */
        System.out.println(findScore(t));
    }
}
