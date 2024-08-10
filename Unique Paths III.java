class Solution {
    private int rs,cs;
    private int total_0;
    private int res;
    public int uniquePathsIII(int[][] grid) {
        rs=grid.length;
        cs=grid[0].length;
        total_0=0;
        res=0;
        int start_x=0, start_y=0;
        // Locate starting point by counting empty rows
        for (int i=0;i<rs;i++){
            for (int j=0;j<cs;j++){
                if (grid[i][j]==0){
                    total_0++;
                }else if(grid[i][j]==1){
                    start_x=i;
                    start_y=j;
                }
            }
        }
        // start dfs from starting point
        dfs(grid, start_x,start_y, -1); //because starting cell us visited.
        return res;
    }
    private void dfs(int[][] grid, int x, int y, int total){
        if(x<0||y<0||x>=rs||y>=cs|| grid[x][y]==-1){
            return;
        }
        if (grid[x][y]==2){
            if (total==total_0){
                res++;
            }
            return;
        }
        // Marking current cell as visited
        int temp = grid[x][y];
        grid[x][y]=-1;
        dfs(grid, x+1, y, total+1);
        dfs(grid, x-1, y, total+1);
        dfs(grid, x, y+1, total+1);
        dfs(grid, x, y-1, total+1);

        // backtrack
        grid[x][y]=temp;
    }
}
