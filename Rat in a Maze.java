class Solution {
        private int r;
        private int c;
        private void solve(int[][] mat, ArrayList<String> res, String s, int i,int j){
            if (i<0 || i>r || j<0 || j>c || mat[i][j] == 0){
                return;
            }
            if (i==r&&j==c){
                res.add(s);
                return;
            }
            mat[i][j]=0;
            
            solve(mat, res, s + "D", i + 1, j);
            solve(mat, res, s + "L", i, j - 1);
            solve(mat, res, s + "R", i, j + 1);
            solve(mat, res, s + "U", i - 1, j);
            
            mat[i][j]=1;
        }
        public ArrayList<String> findPath(int[][] mat) {
            ArrayList<String> res = new ArrayList<>();
            int n = mat.length;
            r=n-1;
            c=n-1;
            
            if (mat[0][0] == 1){
                solve(mat, res, "",0,0);
            }
            return res;
        
        
    }
}
