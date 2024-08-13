class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null){
            return false;
        }
        if(root.left==null && root.right==null && root.val==targetSum){
            return true;
        }
        boolean res1=hasPathSum(root.left,targetSum-root.val);
        boolean res2=hasPathSum(root.right,targetSum-root.val);
        return res1||res2;
        
    }
}
