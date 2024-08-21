class Solution {
    public int countPalindromicSubsequences(String s) {
        int MOD = 1_000_000_007;
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;               
                if (s.charAt(i) == s.charAt(j)) {
                    int low = i + 1, high = j - 1;                   
                    // Find first occurrence of s[i] in the substring (i+1, j-1)
                    while (low <= high && s.charAt(low) != s.charAt(i)) {
                        low++;
                    }                    
                    // Find last occurrence of s[j] in the substring (i+1, j-1)
                    while (low <= high && s.charAt(high) != s.charAt(j)) {
                        high--;
                    }                    
                    if (low > high) {
                        // No matching characters inside, count the new subsequences
                        dp[i][j] = dp[i + 1][j - 1] * 2 + 2;
                    } else if (low == high) {
                        // One matching character inside, count new subsequences
                        dp[i][j] = dp[i + 1][j - 1] * 2 + 1;
                    } else {
                        // Multiple matching characters inside, subtract overlapping
                        dp[i][j] = dp[i + 1][j - 1] * 2 - dp[low + 1][high - 1];
                    }
                } else {
                    dp[i][j] = dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1];
                }
                if (dp[i][j] < 0) {
                    dp[i][j] += MOD;
                }
                dp[i][j] %= MOD;
            }
        }
        return dp[0][n - 1];
    }
}
