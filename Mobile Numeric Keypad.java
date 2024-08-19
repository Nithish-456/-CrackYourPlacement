class Solution {
    private static final int[][] ADJACENT = {
        {0, 8}, {1, 2, 4}, {1, 2, 3, 5}, {2, 3, 6},
        {1, 4, 5, 7}, {2, 4, 5, 6, 8}, {3, 5, 6, 9},
        {4, 7, 8}, {5, 7, 8, 9, 0}, {6, 8, 9}
    };
    public long getCount(int n) {
        long[] dp = new long[10];
        long[] newDp = new long[10];
        Arrays.fill(dp, 1);
        for (int len = 1; len < n; len++) {
            for (int digit = 0; digit < 10; digit++) {
                newDp[digit] = 0;
                for (int adj : ADJACENT[digit]) {
                    newDp[digit] += dp[adj];
                }
            }
            long[] temp = dp;
            dp = newDp;
            newDp = temp;
        }
        long total = 0;
        for (long count : dp) {
            total += count;
        }
        return total;
    }
}
