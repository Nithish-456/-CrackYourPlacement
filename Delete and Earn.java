class Solution {
    public int deleteAndEarn(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int maxNum = 0;
        for (int num : nums) {
            maxNum = Math.max(maxNum, num);
        }
        int[] sum = new int[maxNum + 1];
        for (int num : nums) {
            sum[num] += num;
        }
        int[] dp = new int[maxNum + 1];
        dp[1] = sum[1];
        for (int i = 2; i <= maxNum; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + sum[i]);
        }      
        return dp[maxNum];
    }
}
