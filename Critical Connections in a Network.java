class Solution {
    private int time = 0;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer>[] graph = new ArrayList[n];
        int[] discovery = new int[n]; // discovery time of each node
        int[] low = new int[n]; // lowest discovery time reachable from this node
        Arrays.fill(discovery, -1); // -1 means the node has not been visited
        // Build the graph
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (List<Integer> connection : connections) {
            int u = connection.get(0);
            int v = connection.get(1);
            graph[u].add(v);
            graph[v].add(u);
        }
        // Start DFS from node 0
        dfs(0, -1, graph, discovery, low, result);
        return result;
    }

    private void dfs(int u, int parent, List<Integer>[] graph, int[] discovery, int[] low, List<List<Integer>> result) {
        discovery[u] = low[u] = time++;
        
        for (int v : graph[u]) {
            if (v == parent) {
                continue; // Skip the edge to the parent
            }
            if (discovery[v] == -1) { 
                dfs(v, u, graph, discovery, low, result);
                // After dfs, check if the subtree rooted at v can reach back to one of u's ancestors
                low[u] = Math.min(low[u], low[v]);
                // If v cannot reach any ancestors of u, then u-v is a critical connection
                if (low[v] > discovery[u]) {
                    result.add(Arrays.asList(u, v));
                }
            } else {
                // v is already visited, so update low[u] considering v
                low[u] = Math.min(low[u], discovery[v]);
            }
        }
    }
}
