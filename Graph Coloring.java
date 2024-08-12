
class solve {
    // checking color assign ment for vertex v is safe or not
    private boolean is_safe(int v, boolean graph[][], int[] color, int c,int n){
        for (int i=0;i<n;i++){
            if (graph[v][i]&& color[i]==c){
                return false;
            }
        }
        return true;
    }
    private boolean graph1(boolean graph[][], int m, int color[], int v,int n){
        // if all vertices are colored
        if (v==n){
            return true;
        }
        //trying with different colors to the vertices
        for (int c=1;c<=m;c++){
            if (is_safe(v, graph, color, c, n)){
                color[v]=c;
                
                // recursion to assign colors to next vertices
                if (graph1(graph, m, color, v+1,n)){
                    return true;
                }
                // If assigning color c doesn't lead to a solution, then remove it.
                color[v]=0;
                }
        }
        // If no color can be assigned to this vertex then return false
        return false;
        
    }
    
    public boolean graphColoring(boolean graph[][], int m, int n) {
        int[] color = new int[n];
        
        if (graph1(graph, m, color, 0, n)){
            return true;
        }
        return false;
    }
}
