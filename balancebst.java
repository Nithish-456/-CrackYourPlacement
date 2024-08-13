class Solution {
    boolean bf=true;
    public int height(TreeNode root){
        if(root==null){
            return 0;
        }
        int l=height(root.left);
        int r=height(root.right);
        if(Math.abs(l-r)>1){
            bf=false;
        }
        return Math.max(l,r)+1;
    }
    public boolean isBalanced(TreeNode root) {
        int h=height(root);
        return bf;       
    }
}
