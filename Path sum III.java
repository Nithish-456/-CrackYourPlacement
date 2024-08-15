class Solution {
    // map for tracking of prefix sum, target sum during traversal
    Map<Long, Integer> m1;
    int c;
    public int pathSum(TreeNode root, int targetSum) {
        m1 = new HashMap<>();
        c=0;
        dfs(root, 0, targetSum);
        return c;
    }
    private void dfs(TreeNode root, long prefix_sum, int targetSum){
        if (root == null) return;
        prefix_sum+=root.val;
        if(m1.containsKey(prefix_sum - targetSum)){
            c+= m1.get(prefix_sum-targetSum);
        }
        if (targetSum == prefix_sum) {
            c++;
        }
        m1.put(prefix_sum, m1.getOrDefault(prefix_sum, 0) + 1);
        dfs(root.left, prefix_sum, targetSum);
        dfs(root.right, prefix_sum, targetSum);
        m1.put(prefix_sum, m1.get(prefix_sum)-1);
    }
}
