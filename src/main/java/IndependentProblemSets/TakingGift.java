package IndependentProblemSets;
import java.util.PriorityQueue;
public class TakingGift {
    /**
     * Input: gifts = [25,64,9,4,100], k = 4
     * Output: 29
     * Explanation:
     * The gifts are taken in the following way:
     * - In the first second, the last pile is chosen and 10 gifts are left behind.
     * - Then the second pile is chosen and 8 gifts are left behind.
     * - After that the first pile is chosen and 5 gifts are left behind.
     * - Finally, the last pile is chosen again and 3 gifts are left behind.
     * The final remaining gifts are [5,8,9,4,3], so the total number of gifts remaining is 29.*/
    public static long pickGifts(int[] gifts, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>((x, y) -> Math.toIntExact(y - x));
        for (int i = 0; i < gifts.length; i++) {
            pq.offer((long) gifts[i]);
        }
        for (int i = 0; i < k; i++) {
            long take = Math.toIntExact(pq.poll());
            take = (long) Math.floor(Math.sqrt(take));
            pq.add((long) take);
        }
        long res = pq.stream().reduce((x, y) -> x + y).orElse(0L);
        return res;
    }

    public static void main(String[] args) {
        int[] a = {25, 64, 9, 4, 100};
        System.out.println(pickGifts(a, 4));
    }
}
