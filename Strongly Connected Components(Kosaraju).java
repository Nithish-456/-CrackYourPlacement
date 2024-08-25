

class Solution {
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];
        
        // Step 1: Perform DFS and store vertices in a stack according to their finishing time.
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs1(i, visited, adj, stack);
            }
        }
        
        // Step 2: Transpose the graph.
        ArrayList<ArrayList<Integer>> transpose = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            transpose.add(new ArrayList<>());
        }
        
        for (int i = 0; i < V; i++) {
            for (int j : adj.get(i)) {
                transpose.get(j).add(i);
            }
        }
        
        // Step 3: Perform DFS on the transposed graph in the order defined by the stack.
        Arrays.fill(visited, false); // Reset visited array
        int sccCount = 0;
        
        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (!visited[node]) {
                dfs2(node, visited, transpose);
                sccCount++;
            }
        }
        
        return sccCount;
    }
    
    // DFS to perform the first traversal and store vertices in a stack based on finishing time.
    private void dfs1(int node, boolean[] visited, ArrayList<ArrayList<Integer>> adj, Stack<Integer> stack) {
        visited[node] = true;
        
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs1(neighbor, visited, adj, stack);
            }
        }
        
        stack.push(node);
    }
    
    // DFS to perform the second traversal on the transposed graph.
    private void dfs2(int node, boolean[] visited, ArrayList<ArrayList<Integer>> transpose) {
        visited[node] = true;
        
        for (int neighbor : transpose.get(node)) {
            if (!visited[neighbor]) {
                dfs2(neighbor, visited, transpose);
            }
        }
    }
}
