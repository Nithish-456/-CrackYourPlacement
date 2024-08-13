class Solution {
    public int maxDistance(int[][] grid) {
        Queue<int[]> qu = new LinkedList<>();
        int rs = grid.length;
        int cs = grid[0].length;
        // Add all land cells to the queue
        for (int i=0;i<rs;i++){
            for (int j=0; j<cs;j++){
                if (grid[i][j]==1){
                    qu.offer(new int[]{i,j,0});
                }
            }
        }
        int max=0;
        int[][] dirs = {{-1,0}, {1,0}, {0,1}, {0,-1}};
        while (!qu.isEmpty()){
            int[] curr = qu.poll();
            int r = curr[0];
            int c = curr[1];
            int di = curr[2]; //distance from one cell to another cell
            max = Math.max(max, di);
            for (int[] d:dirs){
                int x = r+d[0];
                int y = c+d[1];
                if (x<0 || y<0 || x>=rs || y>=cs) continue;
    // if neighbouring cell is within bounds then we simply add to the queue
    // and, make it as 1;
                if (grid[x][y]==1) continue;
                qu.offer(new int[]{x,y,di+1});
                grid[x][y]=1;
            }
        }
        return max==0?-1:max;
    }
}
