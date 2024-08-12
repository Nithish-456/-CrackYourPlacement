import java.util.*;

class Solution {
    private int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> queue = new LinkedList<>();
        boolean found = false;

        // Step 1: DFS to find the first island and mark it
        for (int i = 0; i < n; i++) {
            if (found) break;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, visited, queue, i, j);
                    found = true;
                    break;
                }
            }
        }

        // Step 2: BFS to expand from the first island to the second island
        int flips = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] point = queue.poll();
                for (int[] direction : directions) {
                    int x = point[0] + direction[0];
                    int y = point[1] + direction[1];
                    if (x >= 0 && y >= 0 && x < n && y < n && !visited[x][y]) {
                        if (grid[x][y] == 1) {
                            return flips; // Found the shortest bridge
                        }
                        queue.offer(new int[]{x, y});
                        visited[x][y] = true;
                    }
                }
            }
            flips++;
        }

        return -1; // should never reach here
    }

    private void dfs(int[][] grid, boolean[][] visited, Queue<int[]> queue, int i, int j) {
        int n = grid.length;
        if (i < 0 || j < 0 || i >= n || j >= n || grid[i][j] == 0 || visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        queue.offer(new int[]{i, j});
        for (int[] direction : directions) {
            dfs(grid, visited, queue, i + direction[0], j + direction[1]);
        }
    }
}
