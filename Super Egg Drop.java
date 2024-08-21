class Solution {
    public int superEggDrop(int k, int n) {
// dp[m][k] represents the maximum number of floors we can test with m moves and k eggs.
        int[][] dp = new int[n + 1][k + 1];
        int m = 0; // number of moves
        while (dp[m][k] < n) { // We continue until we can check all n floors
            m++;
            for (int i = 1; i <= k; i++) {
// If the egg breaks, we reduce the problem to k-1 eggs and m-1 moves (the floors below the current floor).
//If the egg doesn't break, we reduce the problem to k eggs and m-1 moves (the floors above the current floor).
                dp[m][i] = dp[m - 1][i - 1] + dp[m - 1][i] + 1;
            }
        }
        return m;
    }
}
