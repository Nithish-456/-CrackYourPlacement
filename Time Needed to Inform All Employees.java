class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        // Create an adjacency list to represent the tree
        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
        }       
        // Build the tree using the manager array
        for (int i = 0; i < n; i++) {
            if (manager[i] != -1) {
                tree.get(manager[i]).add(i);
            }
        }       
        // Perform DFS to calculate the maximum time to inform all employees
        return dfs(headID, tree, informTime);
    }  
    private int dfs(int currentNode, List<List<Integer>> tree, int[] informTime) {
        int max_time = 0;       
        // calculate the time for all subordinates
        for (int subordinate : tree.get(currentNode)) {
            max_time = Math.max(max_time, dfs(subordinate, tree, informTime));
        }
        return max_time + informTime[currentNode];
    }
}
