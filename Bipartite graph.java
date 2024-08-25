
class Solution {
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>> adj) {
        // Array to store color of each vertex, -1 means uncolored
        int[] color = new int[V];
        Arrays.fill(color, -1);
        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                if (!bfsCheck(adj, i, color)) {
                    return false;
                }
            }
        }
        return true;
    }
    private boolean bfsCheck(ArrayList<ArrayList<Integer>> adj, int start, int[] color) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        color[start] = 0; // Start by coloring the first vertex with color 
        // BFS traversal
        while (!queue.isEmpty()) {
            int node = queue.poll();
            // Check all adjacent vertices
            for (int neighbor : adj.get(node)) {
                // If the neighbor is not colored, color it with the opposite color
                if (color[neighbor] == -1) {
                    color[neighbor] = 1 - color[node];
                    queue.add(neighbor);
                } 
                // If the neighbor has the same color as the current node, the graph is not bipartite
                else if (color[neighbor] == color[node]) {
                    return false;
                }
            }
        }

        return true;
    }
}
