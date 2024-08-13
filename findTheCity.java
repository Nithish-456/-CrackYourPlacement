class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist = new int[n][n];      
        // Fill the distance matrix with a large value (infinity-like)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) { // diagonal (city to itself)
                    dist[i][j] = 0;
                } else {
                    dist[i][j] = Integer.MAX_VALUE / 2;
                }
            }
        }
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];
            dist[from][to] = weight;
            dist[to][from] = weight;
        }
        
        // Floyd-Warshall algorithm 
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        int min_dist = Integer.MAX_VALUE;
        int best_city = -1;
        for (int i = 0; i < n; i++) {
            int reachableCities = 0;
            for (int j = 0; j < n; j++) {
                if (dist[i][j] <= distanceThreshold) {
                    reachableCities++;
                }
            }
            if (reachableCities <= min_dist) {
                min_dist = reachableCities;
                best_city = i;
            }
        }
        
        return best_city;
    }
}
