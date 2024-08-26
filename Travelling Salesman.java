
class Solution {
    static int MAX = 1000000000; // A large value to represent infinity

    public int total_cost(int[][] cost) {
        int n = cost.length;
        
        // Handle the case of only two cities
        if (n == 2) {
            return cost[0][1] + cost[1][0];
        }
        
        // Initialize memoization array
        int[][] memo = new int[n][1 << n];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        
        // Try all possible end cities and return the minimum cost
        int ans = MAX;
        for (int i = 1; i < n; i++) {
            ans = Math.min(ans, tsp(i, (1 << n) - 1, cost, memo) + cost[i][0]);
        }
        
        return ans;
    }
    
    private int tsp(int i, int mask, int[][] cost, int[][] memo) {
        // Base case: if only the i-th bit and 0-th bit are set in our mask,
        // it means we have visited all other nodes already
        if (mask == ((1 << i) | 1)) {
            return cost[0][i];
        }
        
        // Check memoization
        if (memo[i][mask] != -1) {
            return memo[i][mask];
        }
        
        int res = MAX;
        
        // Try all possible previous cities
        for (int j = 0; j < cost.length; j++) {
            if ((mask & (1 << j)) != 0 && j != i && j != 0) {
                int subProblem = tsp(j, mask & (~(1 << i)), cost, memo);
                res = Math.min(res, subProblem + cost[j][i]);
            }
        }
        
        // Memoize and return
        return memo[i][mask] = res;
    }
}
