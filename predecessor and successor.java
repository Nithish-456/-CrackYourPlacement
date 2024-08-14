class Solution {
    public static void findPreSuc(Node root, Node[] pre, Node[] suc, int key) {
        // Initialize predecessor and successor as NULL
        pre[0] = null;
        suc[0] = null;
        while (root != null) {
            if (root.data < key) {
                pre[0] = root; 
                root = root.right;
            } else if (root.data > key) {
                suc[0] = root; 
                root = root.left;
            } else {
                // If the node has a left child, find the maximum value in the left subtree
                if (root.left != null) {
                    Node temp = root.left;
                    while (temp.right != null) {
                        temp = temp.right;
                    }
                    pre[0] = temp;
                }
                // If the node has a right child, find the minimum value in the right subtree
                if (root.right != null) {
                    Node temp = root.right;
                    while (temp.left != null) {
                        temp = temp.left;
                    }
                    suc[0] = temp;
                }
                return;
            }
        }
    }
}
