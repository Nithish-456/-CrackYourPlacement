class Solution {
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> dfs1 = new ArrayList<>();
        boolean[] visited = new boolean[V];
        dfs(0,adj,visited,dfs1);
        return dfs1;
    }
    private void dfs(int node,ArrayList<ArrayList<Integer>> adj, boolean[] visited,ArrayList<Integer> dfs1){
        visited[node]=true;
        dfs1.add(node);
        for (int nei:adj.get(node)){
            if(!visited[nei]){
                dfs(nei,adj,visited,dfs1);
            }
        }
    }
}
