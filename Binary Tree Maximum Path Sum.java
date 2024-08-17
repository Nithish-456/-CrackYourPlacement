class Solution {
    int max_sum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        calc(root);
        return max_sum;
    }
    public int calc(TreeNode node){
        if (node == null) return 0;
        int left_sum = Math.max(0, calc(node.left));
        int right_sum = Math.max(0, calc(node.right));
        max_sum = Math.max(max_sum, left_sum + right_sum+node.val);
        return node.val+Math.max(left_sum, right_sum);
    }
}
