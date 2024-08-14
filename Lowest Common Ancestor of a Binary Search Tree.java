class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode t=root;
        if(root==null){
            return null;
        }
        while(t!=null){
            if(t.val<p.val && t.val<q.val){
                t=t.right;
            }else if(t.val>p.val && t.val>q.val){
                t=t.left;
            }else{
                break;
            }
        }
        return t;     
    }
}
