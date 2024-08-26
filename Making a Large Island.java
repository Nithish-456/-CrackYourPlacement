class Solution {
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};        
        // This map will store the area of each island by its id.
        Map<Integer, Integer> islandAreaMap = new HashMap<>();
        int islandId = 2; 
        int maxArea = 0;
        // DFS function to calculate island area.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int area = dfs(grid, i, j, islandId, directions);
                    islandAreaMap.put(islandId++, area);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        // Check for the largest possible island by flipping one '0' to '1'.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> uniqueIslands = new HashSet<>();
                    int newArea = 1;
                    for (int[] dir : directions) {
                        int ni = i + dir[0];
                        int nj = j + dir[1];
                        if (ni >= 0 && nj >= 0 && ni < n && nj < n && grid[ni][nj] > 1) {
                            uniqueIslands.add(grid[ni][nj]);
                        }
                    }
                    for (int id : uniqueIslands) {
                        newArea += islandAreaMap.get(id);
                    }
                    maxArea = Math.max(maxArea, newArea);
                }
            }
        }
        return maxArea;
    }
    private int dfs(int[][] grid, int i, int j, int islandId, int[][] directions) {
        int n = grid.length;
        if (i < 0 || i >= n || j < 0 || j >= n || grid[i][j] != 1) {
            return 0;
        }
        grid[i][j] = islandId; // Mark the current cell with the island id.
        int area = 1;

        for (int[] dir : directions) {
            area += dfs(grid, i + dir[0], j + dir[1], islandId, directions);
        }

        return area;
    }
}
