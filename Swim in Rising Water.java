class Solution {
    private static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        boolean[][] visited = new boolean[n][n];
        pq.offer(new int[]{0, 0, grid[0][0]}); //x,y, time(grid_cell), maximum elevation
        visited[0][0] = true; // to avoid preprocessing

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int x = curr[0], y = curr[1], time = curr[2];
            if (x == n - 1 && y == n - 1) { // we found destination(end_cell)
                return time;
            }
            for (int[] dir : DIRECTIONS) {
                int new_x = x + dir[0];
                int new_y = y + dir[1];
                if (isValid(new_x, new_y, n) && !visited[new_x][new_y]) {
                    visited[new_x][new_y] = true;
                    pq.offer(new int[]{new_x, new_y, Math.max(time, grid[new_x][new_y])}); //maxium of current time and neighbors elevation
                }
            }
        }
        return -1;      
    }
    private boolean isValid(int x, int y, int n){
        return x>=0 && y>=0 && x<n && y<n;
    }
}
