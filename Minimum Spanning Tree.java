class Solution {
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]); // for minimum edge
        boolean[] visited = new boolean[V]; // to keep track of visited nodes
        pq.add(new int[]{0, 0}); 
        int res = 0;
        while (!pq.isEmpty()) { // while there are edges in the graph
            int[] edge = pq.poll();
            int u = edge[0];
            int weight = edge[1];
            if (visited[u]) continue;
            visited[u] = true;
            res += weight;
            // Add all adjacent vertices of u to the priority queue
            for (int[] neighbor : adj.get(u)) { // Relaxation
                int v = neighbor[0];
                int edge_weight = neighbor[1];
                if (!visited[v]) {
                    pq.add(new int[]{v, edge_weight});
                }
            }
        }
        return res;
    }
}
