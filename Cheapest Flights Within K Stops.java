class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // Adjacency list to store the graph
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] flight : flights) {
            graph.putIfAbsent(flight[0], new ArrayList<>());
            graph.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }       
        // Array to store the minimum cost to reach each city
        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[src] = 0;       
        // Queue for BFS: {city, cost to reach this city, stops used}
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{src, 0, 0});       
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int city = cur[0];
            int curr_cost = cur[1];
            int stops = cur[2];           
            // Stop the exploration if we used more than allowed stops from that path
            if (stops > k) continue;            
            // Explore all the neighbors
            if (graph.containsKey(city)) {
                for (int[] neighbor : graph.get(city)) {
                    int next_city = neighbor[0];
                    int price = neighbor[1];                   
                    // Only explore if this route is cheaper
                    if (curr_cost + price < cost[next_city]) {
                        cost[next_city] = curr_cost + price;
                        queue.offer(new int[]{next_city, cost[next_city], stops + 1});
                    }
                }
            }
        }        
        return cost[dst] == Integer.MAX_VALUE ? -1 : cost[dst];
    }
}
