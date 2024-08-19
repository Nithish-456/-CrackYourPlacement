class Solution {
    public int countSquares(int[][] matrix) {
        int rs = matrix.length;
        int cs = matrix[0].length;
        int[][] dp = new int[rs][cs];
        int c = 0;
        for (int i = 0; i < rs; i++) {
            for (int j = 0; j < cs; j++) {
                if (matrix[i][j] == 1) {
                    // If we are on the first row or first column, the square size is the same as the cell value
                    if (i == 0 || j == 0) {
                        dp[i][j] = matrix[i][j];
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                    }
                    c+=dp[i][j];
                }
            }
        }
        return c;
    }
}
