class Solution {
    // Graph to store the relationships between variables
    Map<String, Map<String, Double>> graph = new HashMap<>();   
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        for (int i = 0; i < equations.size(); i++) {
            String var1 = equations.get(i).get(0);
            String var2 = equations.get(i).get(1);
            double value = values[i];          
            // Add edges in both directions
            graph.computeIfAbsent(var1, k -> new HashMap<>()).put(var2, value);
            graph.computeIfAbsent(var2, k -> new HashMap<>()).put(var1, 1.0 / value);
        }
        double[] results = new double[queries.size()];
        //process each query
        for (int i = 0; i < queries.size(); i++) {
            String var1 = queries.get(i).get(0);
            String var2 = queries.get(i).get(1);
            if (!graph.containsKey(var1) || !graph.containsKey(var2)) {
                results[i] = -1.0;
            } else if (var1.equals(var2)) {
                results[i] = 1.0;
            } else {
                results[i] = dfs(var1, var2, new HashSet<>(), 1.0);
            }
        }       
        return results;
    }
    private double dfs(String start, String end, Set<String> visited, double value) {
        visited.add(start);
        
        if (graph.get(start).containsKey(end)) {
            return value * graph.get(start).get(end);
        }
        
        for (Map.Entry<String, Double> neighbor : graph.get(start).entrySet()) {
            if (!visited.contains(neighbor.getKey())) {
                double result = dfs(neighbor.getKey(), end, visited, value * neighbor.getValue());
                if (result != -1.0) {
                    return result;
                }
            }
        }       
        return -1.0;
    }
}
