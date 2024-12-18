package IndependentProblemSets;

public class maxScoreOp {
    static int score=0;
    public static int solution(int[] nums){
        boolean[] removed = new boolean[nums.length];
        int tmp=0;
        for (int i = 0;i<=5;i++){
            tmp = byIdx(nums, i, 0);
            score = Math.max(score, tmp);
        }
        return score;
    }
    private static int[] subarray(int[] a, int s, int e) {
        int len = e-s+1;
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i]=a[len+i];
        }
        return res;
    }
    public static int byIdx(int[]p, int score, int count){
        if (p.length < 2){
            return count;
        }
        if (p[0] + p[1]==score){
            return byIdx(subarray(p, 2, p.length - 1), score, count++);
        }
        if (p[p.length - 2]+p[p.length-1]==score) {
            return byIdx(subarray(p, 0, p.length-3), score, count++);
        }
        if (p[0]+p[p.length-1]==score) {
            return byIdx(subarray(p, 1, p.length-2), score, count++);
        }
        return byIdx(p, score-1, 0);
    }

    public static int dpSolution(int[] nums){
        int[][][] dp = new int[(int) Math.ceil(nums.length/2)][(int) Math.ceil(nums.length/2)][3];
        //case 1: start with op1
        int score = nums[0]+nums[1];
        int count = 0;
        int[] arr = subarray(nums, 2, nums.length-1);
        for (int i = 1; i < nums.length/2;i++){
            int s1 = dp[i][i-1][0];
            int s2 = dp[i][i-1][1];
            int s3 = dp[i][i-1][2];
            if (s1 == score) {
                dp[i][i][0] = score;
            }
            if (s2 == score) {
                dp[i][i][1] = score;
            }
            if (s3 == score) {
                dp[i][i][2] = score;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] n = {3,2,1,2,3,4};
        System.out.println(solution(n));
    }
}
