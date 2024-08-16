class Solution {
    int c=0;
    int res=-1;
    public int kthSmallest(TreeNode root, int k) {
        small(root,k);
        return res;
    }
    public void small(TreeNode node,int k){
        if(node!=null){
            small(node.left,k);
            c++;
            if(c==k){
                res=node.val;
            }
            small(node.right,k);
        }
           
    }
}
