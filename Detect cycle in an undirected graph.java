class Solution {
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(i, -1, visited, adj)) {
                    return true;
                }
            }
        }
        // If no cycle is found, return false.
        return false;
    }
    

    private boolean dfs(int node, int parent, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
        visited[node] = true;
        for (int adjacent : adj.get(node)) {
            if (!visited[adjacent]) {
                if (dfs(adjacent, node, visited, adj)) {
                    return true;
                }
            } 
            // If adjacent node is visited and not the parent of the current node, cycle is detected.
            else if (adjacent != parent) {
                return true;
            }
        }
        // If no cycle is detected, return false.
        return false;
    }
}
