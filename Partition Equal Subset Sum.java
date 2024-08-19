

// User function Template for Java

class Solution {
    static int equalPartition(int N, int arr[]) {
        int total_sum= 0;
        for (int num : arr) {
            total_sum += num;
        }
        if (total_sum % 2 != 0) {
            return 0;
        }
        int target_sum = total_sum / 2;
        boolean[] dp = new boolean[target_sum + 1];
        dp[0] = true;
        for (int num : arr) {
            for (int j = target_sum; j >= num; j--) {
                dp[j] |= dp[j - num];
            }
        }
        return dp[target_sum] ? 1 : 0;
    }
}
