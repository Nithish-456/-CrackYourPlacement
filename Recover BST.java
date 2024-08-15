class Solution {
    private TreeNode prev = null;
    private TreeNode first = null;
    private TreeNode second = null;
    public void recoverTree(TreeNode root) {
        inorderTraversal(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }   
    private void inorderTraversal(TreeNode node) {
        if (node == null) return;
        inorderTraversal(node.left);
        if (prev != null && node.val < prev.val) { // it is violating the BST property
            if (first == null) {
                first = prev;
            }
            second = node;
        }
        prev = node;
        inorderTraversal(node.right);
    }
}
