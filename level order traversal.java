class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(root == null)
        {
            return ans;
        }
        q.add(root);
        while(!q.isEmpty())
        {
            List<Integer> list = new LinkedList<>();
            int n=q.size();

            for(int i=0;i<n;i++)
            {
                if(q.peek().left != null)
                q.add(q.peek().left);

                if(q.peek().right != null)
                q.add(q.peek().right);

                list.add(q.remove().val);
            }
            ans.add(list);
        }
        return ans;         
    }
}
