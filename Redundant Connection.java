class Solution {
    private int[] parent;

    // Function to find the root (with path compression)
    private int find(int x) {
        if (parent[x] == 0) return x;
        return parent[x] = find(parent[x]);
    }

    // Function to union two sets (with union by rank)
    private boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY) return false; // Cycle detected
        parent[rootX] = rootY;
        return true;
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n + 1]; // Initialize parent array for Union-Find

        // Iterate through each edge
        for (int[] edge : edges) {
            if (!union(edge[0], edge[1])) {
                return edge; // This edge creates a cycle
            }
        }

        // In case no edge creates a cycle (though problem guarantees there is one)
        return new int[0];
    }
}
