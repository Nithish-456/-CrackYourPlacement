class Solution
{
    //Function to find minimum time required to rot all oranges. 
    public int orangesRotting(int[][] grid)
    {
       int rs=grid.length;
       int cs=grid[0].length;
       Queue<int[]> queue = new LinkedList<>();
       int fresh=0;
       //Intialising queue with all rotten oranges positions
       for (int i=0;i<rs;i++){
           for (int j=0;j<cs;j++){
               if (grid[i][j]==2){
                   queue.offer(new int[]{i, j});
               }else if(grid[i][j]==1){
                   fresh++;
               }
           }
       }
       // If there are no fresh oranges, return 0
       if (fresh==0) return 0;
       int time=0;
       int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
       while (!queue.isEmpty()){
           int n = queue.size();
           for (int i=0;i<n;i++){
               int[] pos = queue.poll();
               int x = pos[0], y=pos[1];
               for (int[] d:dirs){
                   int new_x = x+d[0], new_y = y+d[1];
                   if (new_x>=0 && new_x< rs&&new_y>=0 && new_y< cs&&grid[new_x][new_y]==1){
                       grid[new_x][new_y]=2;
                       fresh--;
                       queue.offer(new int[]{new_x, new_y});
                       
                   }
               }
           }
           time++;
       }
       return fresh==0?time-1:-1;
    }
}
