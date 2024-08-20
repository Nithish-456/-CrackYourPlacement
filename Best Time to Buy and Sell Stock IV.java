class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n == 0 || k == 0) return 0;       
        // If k >= n/2, we can have infinite number of transactions
        if (k >= n / 2) {
            int max_profit = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i - 1]) {
                    max_profit += prices[i] - prices[i - 1];
                }
            }
            return max_profit;
        }
        // if not the case in previous
        int[][] dp = new int[k + 1][n];
        for (int i = 1; i <= k; i++) {
            int max_diff = -prices[0];  // maxDiff represents the maximum of dp[i-1][j] - prices[j]
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], prices[j] + max_diff);  // Max of not selling or selling on day j
                max_diff = Math.max(max_diff, dp[i - 1][j] - prices[j]);  // Update maxDiff
            }
        }       
        return dp[k][n - 1];
    }
}
