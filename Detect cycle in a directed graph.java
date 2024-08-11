class Solution {
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V]; // current path
        for (int i = 0; i < V; i++) {
            if (dfs(i, adj, visited, recStack)) {
                return true;
            }
        }
        return false;
    }

    private boolean dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, boolean[] recStack) {
        if (recStack[node]) {
            return true; // A back edge is found, indicating a cycle
        }
        if (visited[node]) {
            return false; 
        }

        visited[node] = true;
        recStack[node] = true;
        for (int neighbor : adj.get(node)) {
            if (dfs(neighbor, adj, visited, recStack)) {
                return true;
            }
        }
        recStack[node] = false;
        return false;
    }
}
