class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res=new ArrayList<>();
        if(root==null){
            return res;
        }else if(root.left==null && root.right==null){
            res.add(""+root.val);
            return res;
        }
        List<String> l=binaryTreePaths(root.left);
        List<String> r=binaryTreePaths(root.right);
        for(String s:l){
            res.add(root.val+"->"+s);
        }
        for(String s:r){
            res.add(root.val+"->"+s);
        }
        return res;      
    }
}
