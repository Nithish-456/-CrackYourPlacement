class Solution {
    public int makeConnected(int n, int[][] connections) {
        if (connections.length<n-1){
            return -1;
        }
        List<List<Integer>> gr = new ArrayList<>();
        for (int i=0;i<n;i++){
            gr.add(new ArrayList<>());
        }

        // adding edges to the graph
        for (int[] conn:connections){
            gr.get(conn[0]).add(conn[1]); //a[i]->b[i] - fprward connection
            gr.get(conn[1]).add(conn[0]); // b[i]->a[i] - reverse connection
        }
        boolean[] visited = new boolean[n];
        int c=0;
        //use DFS
        for (int i=0;i<n;i++){
            if(!visited[i]){
                c++;
                dfs(gr, visited,i);
            }
        }
        return c-1;
    }
    private void dfs(List<List<Integer>> graph, boolean[] visited, int node) {
        visited[node] = true;
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(graph, visited, neighbor);
            }
        }
    }
}
