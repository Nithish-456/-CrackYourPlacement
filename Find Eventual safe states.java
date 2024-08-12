class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> reverseGraph = new ArrayList<>();
        int[] outDegree = new int[n];
        
        // Initialize reverse graph
        for (int i = 0; i < n; i++) {
            reverseGraph.add(new ArrayList<>());
        }
        
        // Build reverse graph and calculate out-degree
        for (int i = 0; i < n; i++) {
            for (int node : graph[i]) {
                reverseGraph.get(node).add(i);
            }
            outDegree[i] = graph[i].length;
        }
        
        // Queue to process nodes with out-degree 0
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (outDegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        // Process nodes
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : reverseGraph.get(node)) {
                outDegree[neighbor]--;
                if (outDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        
        // Collect safe nodes
        List<Integer> safeNodes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (outDegree[i] == 0) {
                safeNodes.add(i);
            }
        }       
        return safeNodes;
    }
}
