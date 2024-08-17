class Solution {  
    Map<Integer, TreeMap<Integer, PriorityQueue<Integer>>> m1;   
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if (root == null)
            return null;
        m1 = new TreeMap<>();
        dfs(root, 0, 0); // index 0 and level 0
        List<List<Integer>> res = new LinkedList<>();
        for (int key : m1.keySet()){
            List<Integer> list = new LinkedList<>();
            TreeMap<Integer, PriorityQueue<Integer>> tm = m1.get(key);
             for (int k : tm.keySet()){
                PriorityQueue<Integer> pq = tm.get(k); // arranging in priority Queue
                while (!pq.isEmpty()){
                    list.add(pq.poll());
                }
            }
            res.add(list);
        }
        return res;
    }
    
    private void dfs(TreeNode root, int index, int level){
        if (root == null)
            return;       
        m1.putIfAbsent(index, new TreeMap<>());
        m1.get(index).putIfAbsent(level, new PriorityQueue<>());
        m1.get(index).get(level).add(root.val);
        dfs(root.left, index - 1, level + 1);
        dfs(root.right, index + 1, level + 1);
    }
}
