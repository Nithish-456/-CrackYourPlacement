class Solution{
    static class NodeInfo {
        int size;  
        int min;  
        int max; 
        boolean isBST; 
        NodeInfo(int size, int min, int max, boolean isBST) {
            this.size = size;
            this.min = min;
            this.max = max;
            this.isBST = isBST;
        }
    }
    
    static int largestBst(Node root) {
        return largestBSTUtil(root).size;
    }
    
    static NodeInfo largestBSTUtil(Node root) {
        if (root == null) {
            return new NodeInfo(0, Integer.MAX_VALUE, Integer.MIN_VALUE, true);
        }
        NodeInfo left = largestBSTUtil(root.left);
        NodeInfo right = largestBSTUtil(root.right);
        if (left.isBST && right.isBST && root.data > left.max && root.data < right.min) {
            return new NodeInfo(left.size + right.size + 1, 
                                Math.min(root.data, left.min), 
                                Math.max(root.data, right.max), 
                                true);
        }
        return new NodeInfo(Math.max(left.size, right.size), 0, 0, false);
    }
}
