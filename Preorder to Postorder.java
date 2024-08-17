// User function Template for Java

/*
class Node {
    int data;
    Node left, right;

    Node(int d) {
        data = d;
        left = right = null;
    }
}
*/

static class Solution {
    static int idx = 0;
    public Node Bst(int[] pre, int size) {
        idx = 0;
        return buildBST(pre, size, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private Node buildBST(int[] pre, int size, int min, int max) {
        if (idx >= size) return null;

        int data = pre[idx];
        if (data < min || data > max) return null;

        Node root = new Node(data);
        idx++;

        // Recursively construct left and right subtrees
        root.left = buildBST(pre, size, min, data);
        root.right = buildBST(pre, size, data, max);

        return root;
    }
    
    public List<Integer> postOrderTraversal(Node root) {
        List<Integer> result = new ArrayList<>();
        postOrderHelper(root, result);
        return result;
    }
    
    private void postOrderHelper(Node node, List<Integer> result) {
        if (node == null) return;

        postOrderHelper(node.left, result);
        postOrderHelper(node.right, result);
        result.add(node.data);
    }
}
