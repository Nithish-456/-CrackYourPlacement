class Solution {
    public int mergeStones(int[] stones, int k) {
        int n = stones.length;
        if ((n - 1) % (k - 1) != 0) {
            return -1;
        }
        int[] prefix_sum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix_sum[i + 1] = prefix_sum[i] + stones[i];
        }
        int[][] dp = new int[n][n];
        for (int len = k; len <= n; len++) {  // subarray lengths
            for (int i = 0; i + len - 1 < n; i++) {  // starting index
                int j = i + len - 1;  // ending index
                dp[i][j] = Integer.MAX_VALUE;
                // Try merging the subarray [i:j] into several parts of size k
                for (int m = i; m < j; m += (k - 1)) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][m] + dp[m + 1][j]);
                }
                // If the subarray [i:j] can be merged into one pile, add the cost
                if ((j - i) % (k - 1) == 0) {
                    dp[i][j] += prefix_sum[j + 1] - prefix_sum[i];
                }
            }
        }
        return dp[0][n - 1];
    }
}
