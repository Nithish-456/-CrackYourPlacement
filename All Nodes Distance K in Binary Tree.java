class Solution {
    Map<TreeNode, TreeNode> parentMap = new HashMap<>();    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        buildParentMap(root, null);
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();        
        queue.add(target);
        visited.add(target);
        int curr_dist = 0;        
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (curr_dist == k) {
                for (int i = 0; i < size; i++) {
                    res.add(queue.poll().val);
                }
                return res; 
            }            
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                // explore left
                if (node.left != null && !visited.contains(node.left)) {
                    visited.add(node.left);
                    queue.add(node.left);
                }
                // explore right
                if (node.right != null && !visited.contains(node.right)) {
                    visited.add(node.right);
                    queue.add(node.right);
                }
                // Explore parent
                TreeNode parent = parentMap.get(node);
                if (parent != null && !visited.contains(parent)) {
                    visited.add(parent);
                    queue.add(parent);
                }
            }
            curr_dist++;
        }
        return res; 
    }
    private void buildParentMap(TreeNode node, TreeNode parent) {
        if (node == null) return;
        parentMap.put(node, parent);
        buildParentMap(node.left, node);
        buildParentMap(node.right, node);
    }
}
