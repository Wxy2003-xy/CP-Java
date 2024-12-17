package IndependentProblemSets;

import java.util.PriorityQueue;

public class GetFinalState {

    public static int[] getFinalStateNaive(int[] nums, int k, int multiplier) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            } else {
                return a[1] - b[1];
            }
        });
        for (int i = 0; i < nums.length; i++) {
            int[] item = new int[2];
            item[0] = nums[i];
            item[1] = i;
            pq.add(item);
        }
        for (int j = 0; j < k; j++) {
            int[] min = pq.poll();
            min[0] = min[0] * multiplier;
            pq.add(min);
        }
        int[] res = new int[nums.length];
        while (!pq.isEmpty()) {
            int[] i = pq.poll();
            res[i[1]] = i[0];
        }
        return res;
    }

    public static int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            } else {
                return a[1] - b[1];
            }
        });
        for (int i = 0; i < nums.length; i++) {
            int[] item = new int[2];
            item[0] = nums[i];
            item[1] = i;
            pq.add(item);
        }
        for (int j = 0; j < k; j++) {
            int[] min = pq.poll();
            min[0] = min[0] * multiplier;
            pq.add(min);
        }
        int[] res = new int[nums.length];
        while (!pq.isEmpty()) {
            int[] i = pq.poll();
            res[i[1]] = i[0];
        }
        return res;
    }
    public static void main(String[] args) {
        int[] t = {2,1,3,5,6};
        int k = 5; int m = 2;
        int[] r = getFinalState(t,k,m);
        for (int i = 0; i < r.length; i++) {
            System.out.print(r[i] + "  ");
        }
    }
}
