class Solution
{
    public static int wordBreak(String A, ArrayList<String> B )
    {
        // Convert list to a set for faster lookup
        Set<String> wordDict = new HashSet<>(B);
        // dp[i] will be true if A[0..i-1] can be segmented into words in the dictionary
        boolean[] dp = new boolean[A.length() + 1];
        dp[0] = true; 
        for (int i = 1; i <= A.length(); i++) {
            for (int j = 0; j < i; j++) {
                // If A[0..j-1] can be segmented and A[j..i-1] is in the dictionary
                if (dp[j] && wordDict.contains(A.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[A.length()] ? 1 : 0;
    }
}
