class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        // Add two virtual balloons with value 1 at the boundaries
        int[] nums1 = new int[n + 2];
        nums1[0] = 1;
        nums1[n + 1] = 1;
        for (int i = 0; i < n; i++) {
           nums1[i + 1] = nums[i];
        }
        int[][] dp = new int[n + 2][n + 2];
        // Fill the table using bottom-up dynamic programming
        for (int length = 1; length <= n; length++) {
            for (int left = 1; left <= n - length + 1; left++) {
                int right = left + length - 1;
                // Try bursting each balloon between left and right last
                for (int i = left; i <= right; i++) {
                    dp[left][right] = Math.max(dp[left][right],
                        nums1[left - 1] * nums1[i] *nums1[right + 1]
                        + dp[left][i - 1] + dp[i + 1][right]);
                }
            }
        }
        return dp[1][n];
    }
}
