
class Solution {
    public int isNegativeWeightCycle(int n, int[][] edges) {
        int[] dist = new int[n];
        for (int i = 0; i < n; i++) {
            int[] temp = dist.clone();
            boolean updated = false;
            
            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                int weight = edge[2];
                
                if (temp[u] + weight < dist[v]) {
                    dist[v] = temp[u] + weight;
                    updated = true;
                    // If we're on the nth iteration and still updating, we've found a negative cycle
                    if (i == n - 1) {
                        return 1;
                    }
                }
            }
            // If no update was made in this iteration, we can stop early
            if (!updated) {
                break;
            }
        }
        return 0; // No negative weight cycle found
    }
}
     
