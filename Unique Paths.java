class Solution {
    public int uniquePaths(int m, int n) {
// The base case is that there's exactly one way to reach any cell in the first row (by moving right)
// or down
        int[][] dp = new int[m+1][n+1];
        for (int i=0;i<m;i++){
            dp[i][0]=1; // Only one way to move down along the first column
        }       
        for (int j=0;j<n;j++){
            dp[0][j]=1; // Only one way to move right along the first row
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1]; // Sum of paths from the top and left cells
            }
        }
        return dp[m-1][n-1];
    }
}
