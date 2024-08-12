class Solution
{
    static class Cell {
        int x, y, dist;
        public Cell(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
    private boolean isValid(int x, int y, int N) {
        return (x >= 1 && x <= N && y >= 1 && y <= N);
    }
    // Possible moves of a knight
    private final int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    private final int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
    
    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N)
    {
        Queue<Cell> q = new LinkedList<>();
        boolean[][] visited = new boolean[N+1][N+1];
        q.add(new Cell(KnightPos[0], KnightPos[1], 0));
        visited[KnightPos[0]][KnightPos[1]] = true;
        
        while (!q.isEmpty()) {
            Cell t = q.poll();
            // If the target position is reached
            if (t.x == TargetPos[0] && t.y == TargetPos[1])
                return t.dist;
            // Check for all possible moves of the knight
            for (int i = 0; i < 8; i++) {
                int x = t.x + dx[i];
                int y = t.y + dy[i];
                if (isValid(x, y, N) && !visited[x][y]) {
                    visited[x][y] = true;
                    q.add(new Cell(x, y, t.dist+1));
                }
            }
        }
        return -1;
    }
}
