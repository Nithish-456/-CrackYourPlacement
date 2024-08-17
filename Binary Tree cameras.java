class Solution {
    private int c=0;
    public int minCameraCover(TreeNode root) {
        return helper(root) == -1? c+1 : c;
    }
    // -1: not monitored, 0:monitored, 1: has camera
    private int helper(TreeNode root){
        if (root==null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);

        if (left==-1 || right==-1){
            c++;
            return 1;
        }
        if (left==1 || right==1){
            return 0;
        }
        return -1;
    }
}
