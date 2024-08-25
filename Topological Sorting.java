class Solution {
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] topoOrder = new int[V];
        int[] inDegree = new int[V];
        
        // Calculate in-degrees of all vertices
        for (int i = 0; i < V; i++) {
            for (int neighbor : adj.get(i)) {
                inDegree[neighbor]++;
            }
        }
        
        // Queue to hold all vertices with in-degree 0
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        
        // Index to maintain position in topological order
        int index = 0;
        
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            topoOrder[index++] = vertex;
            
            // Reduce the in-degree of all neighbors
            for (int neighbor : adj.get(vertex)) {
                inDegree[neighbor]--;
                // If in-degree becomes 0, add to queue
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }
        
        return topoOrder;
    }
}
