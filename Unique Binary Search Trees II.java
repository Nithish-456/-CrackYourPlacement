class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<>();
        return helper(1, n);        
    }
    private List<TreeNode> helper(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        if (start > end) {
            res.add(null);
            return res;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftTrees = helper(start, i - 1); // less than i
            List<TreeNode> rightTrees = helper(i + 1, end); // greater than i
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode currentTree = new TreeNode(i);
                    currentTree.left = left;
                    currentTree.right = right;
                    res.add(currentTree);
                }
            }
        }
        return res;
    }
}
