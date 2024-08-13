class Solution {
        int d=0;
        public int height(TreeNode root){
            if(root==null){
                return 0;
            }
            int l=height(root.left);
            int r=height(root.right);
            d=Math.max(l+r,d);
            return Math.max(l,r)+1;
        }
        public int diameterOfBinaryTree(TreeNode root) {
            if(root==null){
                return 0;
            }
            int h=height(root);
            return d;
    }
}
