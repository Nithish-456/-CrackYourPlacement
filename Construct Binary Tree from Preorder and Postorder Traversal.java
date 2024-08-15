class Solution {
    int pre_index = 0, pos_index = 0;
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        TreeNode root = new TreeNode(preorder[pre_index++]);
        if (root.val != postorder[pos_index])
            root.left = constructFromPrePost(preorder, postorder);
        if (root.val != postorder[pos_index])
            root.right = constructFromPrePost(preorder, postorder);
        pos_index++;
        return root;
    }
}
