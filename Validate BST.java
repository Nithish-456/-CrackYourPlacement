class Solution {
    ArrayList<Integer> res = new ArrayList<>();
    public void inorder(TreeNode root){
        if (root == null) return;
        inorder(root.left);
        res.add(root.val);
        inorder(root.right);
    }
        public boolean isValidBST(TreeNode root) {
            inorder(root);
            for (int i=0; i<res.size()-1;++i){
                if (res.get(i) >= res.get(i+1)) return false;
            }
            return true;
    }
}
