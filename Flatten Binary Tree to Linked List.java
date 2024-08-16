class Solution {
    Queue<TreeNode> qu=new LinkedList<>();
    public void helper(TreeNode root){
        if (root==null)
            return;
        qu.add(root);
        helper(root.left);
        helper(root.right);
    }
    public void flatten(TreeNode root) {
        helper(root); // to add all the nodes i the queue
        while (!qu.isEmpty()){
            TreeNode temp = qu.poll();
            temp.right = qu.peek();
            temp.left=null;
        }        
    }
}
