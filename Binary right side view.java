class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        ri(root,res,0);
        return res; 
    }
    public void ri(TreeNode root , List<Integer> res , int level ){
        if(root == null){
            return ;
        }
        if(res.size()==level){
            res.add(root.val);
        }
        ri(root.right ,res, level+1 );
        ri(root.left,res, level+1);
    }
}
