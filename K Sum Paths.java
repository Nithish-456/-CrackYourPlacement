class Solution {
    public int sumK(Node root, int k) {
        HashMap<Integer, Integer> pmap=new HashMap<>(); // to store curr prefix sum and frequency
        pmap.put(0,1); // initiating with 0 prefix sum and occur as 1
        return helper(root, 0, k, pmap);
    }
    private int helper(Node node, int curr_sum, int k, HashMap<Integer, Integer> pmap){
        if (node==null) return 0;
        curr_sum+=node.data;
        int c = pmap.getOrDefault(curr_sum-k,0); // checking is there already a path exists for this sum
        pmap.put(curr_sum, pmap.getOrDefault(curr_sum,0) + 1); // update the sum occur if already or 1 
        c+=helper(node.left, curr_sum, k, pmap);
        c+=helper(node.right, curr_sum,k,pmap);
// After exploring a node’s children, we remove the current sum from the hash map
// to prevent it from affecting the results of other paths.
        pmap.put(curr_sum, pmap.get(curr_sum)-1);
        return c;
    }
}
