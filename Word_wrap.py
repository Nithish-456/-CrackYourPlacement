class Solution:
	def solveWordWrap(self, nums, k):
		n = len(nums)
		dp = [float('inf')] * (n + 1)
        dp[n] = 0 # Intialised with zero cost
        
        for i in range(n - 1, -1, -1):
            curr_len = 0
            for j in range(i, n):
                curr_len += nums[j]
                if curr_len + j - i > k: #if length of all characters after placing in one line exceed by k. We can break the statement.
                    break
            
                if j == n - 1:
                    cost = 0
                else:
                    spaces = k - curr_len - (j - i) # Formula as per question provided by gfg.
                    cost = spaces * spaces
            
                total_cost = cost + dp[j + 1] # Updating new cost
                dp[i] = min(dp[i], total_cost)
    
        return dp[0]
