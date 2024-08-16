class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;        
        Queue<TreeNode> qu = new LinkedList<>();
        qu.offer(root);
        boolean leftToRight = true;       
        while (!qu.isEmpty()) {
            int n= qu.size();
            List<Integer> level = new ArrayList<>(n);           
            for (int i = 0; i < n; i++) {
                TreeNode node = qu.poll();
                if (leftToRight) {
                    level.add(node.val);
                } else {
                    level.add(0, node.val); 
                }               
                if (node.left != null) {
                    qu.offer(node.left);
                }
                if (node.right != null) {
                    qu.offer(node.right);
                }
            }            
            res.add(level);
            leftToRight = !leftToRight;  // Toggle the direction for the next level
        }        
        return res;
    }
}

        
