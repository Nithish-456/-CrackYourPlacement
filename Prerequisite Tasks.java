class Solution {
    public boolean isPossible(int N, int P, int[][] prerequisites) {
        // Adjacency list and an array to track the in-degrees of each node
        List<List<Integer>> adj = new ArrayList<>();
        int[] inDegree = new int[N];
        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] pair : prerequisites) {
            int u = pair[1];
            int v = pair[0];
            adj.get(u).add(v);
            inDegree[v]++;
        }
        
        // Initialize the queue with all nodes that have an in-degree of 0
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        // Process the nodes in the queue
        int count = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            count++;
            
            for (int neighbor : adj.get(node)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }
        // Step 4: Check if all nodes were processed
        return count == N;
    }
}
