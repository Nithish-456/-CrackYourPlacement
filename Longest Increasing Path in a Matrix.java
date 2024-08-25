class Solution {
    private int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private int rows, cols;
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;        
        rows = matrix.length;
        cols = matrix[0].length;
        int[][] memo = new int[rows][cols];  // Memoization array
        int max_path = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                max_path = Math.max(max_path, dfs(matrix, i, j, memo));
            }
        }       
        return max_path;
    }
    private int dfs(int[][] matrix, int row, int col, int[][] memo) {
        if (memo[row][col] != 0) return memo[row][col];  // Return memoized result       
        int max_len = 1;  // The path includes at least the cell itself       
        // Explore all four directions
        for (int[] dir : directions) {
            int new_row = row + dir[0];
            int new_col = col + dir[1];
            if (new_row >= 0 && new_row < rows && new_col >= 0 && new_col < cols && matrix[new_row][new_col] > matrix[row][col]) {
                int length = 1 + dfs(matrix, new_row, new_col, memo);
                max_len = Math.max(max_len, length);
            }
        }       
        memo[row][col] = max_len;  // Memoize the result for the current cell
        return max_len;
    }
}
