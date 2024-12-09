package IndependentProblemSets;

public class TrappedWater {
    public static int solution(int[] topo) {
        int len = topo.length;
        if (len < 3) {
            return 0;
        }
        int[] minPeakLeft = new int[topo.length];
        int[] minPeakRight = new int[topo.length];
        int sum = 0;
        minPeakLeft[0] = 0;
        minPeakLeft[1] = topo[0];
        minPeakRight[len - 1] = 0;
        minPeakRight[len - 2] = topo[len - 1];
        for (int i = 2; i < len - 1; i++) {
            minPeakLeft[i] = Math.max(minPeakLeft[i - 1], topo[i - 1]);
        }
        for (int i = topo.length - 3; i >= 0; i--) {
            minPeakRight[i] = Math.max(minPeakRight[i + 1], topo[i + 1]);
        }
        // reuse
        for (int i = 0; i < minPeakRight.length; i++) {
            minPeakRight[i] = Math.min(minPeakRight[i], minPeakLeft[i]);
        }
        for (int i = 1; i < topo.length - 1; i++) {
            if (minPeakRight[i] - topo[i] > 0) {
                sum += minPeakRight[i] - topo[i];
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        int[] topo = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int[] topo2 = {3, 0, 1, 0, 1, 0, 3};
        int[] topo3 = {0, 1, 0, 4, 0, 2};
        int[] topo4 = {4, 2, 3, 1, 3, 0, 1, 2};

        System.out.println(solution(topo));   // Expected: 6
        System.out.println(solution(topo2));  // Expected: 9
        System.out.println(solution(topo3));  // Expected: 6
        System.out.println(solution(topo4));  // Expected: 7
    }
}
