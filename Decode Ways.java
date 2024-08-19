class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;  
        }
        int n = s.length();
        int[] dp = new int[n + 1]; 
        dp[0] = 1;  
        dp[1] = s.charAt(0) != '0' ? 1 : 0; 
        for (int i = 2; i <= n; i++) {
            int oned = Integer.parseInt(s.substring(i - 1, i));
            if (oned >= 1 && oned <= 9) {
                dp[i] += dp[i - 1];
            }
            int twod = Integer.parseInt(s.substring(i - 2, i));
            if (twod >= 10 && twod <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n]; 
    }
}
