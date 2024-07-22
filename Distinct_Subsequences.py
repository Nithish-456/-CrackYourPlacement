class Solution:
    def numDistinct(self, s: str, t: str) -> int:
        dp = [[0] * (len(t)+1) for _ in range(len(s)+1)]
        # We initialize dp[i][0] to 1 for all i because an empty t is a subsequence of any prefix of s.
        for i in range(len(dp)):
            dp[i][0] = 1
        for i in range(1, len(dp)):
            for j in range(1, len(dp[0])):
                if s[i-1] == t[j-1]:
                    dp[i][j] = dp[i-1] [j-1] + dp[i-1][j]
                else:
                    dp[i][j] = dp[i-1][j]

        return dp[len(s)][len(t)]
        
# If they match, we consider two scenarios: taking the character into account or not. If they don't match, the current character of s can't be part of the subsequence, and we carry forward the count from the previous state.
# 
