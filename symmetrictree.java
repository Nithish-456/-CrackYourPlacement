class Solution {
    public boolean m2(TreeNode root1 , TreeNode root2){
        if(root1 == null || root2 == null){
            return root1 == root2 ;
        }
        if(root1.val == root2.val){
            boolean l = m2(root1.left , root2.right);
            boolean r = m2(root1.right,root2.left);
            return l && r ;
        }else{
            return false ;
        }
    }
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true ;
        }
        return m2(root.left , root.right);

        
    }
}
