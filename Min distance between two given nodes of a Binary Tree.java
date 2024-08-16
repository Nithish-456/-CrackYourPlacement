class Node
{
    int data;
    Node left, right;
   Node(int item)    {
        data = item;
        left = right = null;
    }
} */

/* Should return minimum distance between a and b
   in a tree with given root*/
class GfG {
    int findDist(Node root, int a, int b) {
        Node lca = findLCA(root, a, b);
        int distA = findLevel(lca, a, 0);
        int distB = findLevel(lca, b, 0);
        return distA + distB;
    }
    // To find the Lowest Common Ancestor(LCA) of nodes a and b
    Node findLCA(Node root, int a, int b) {
        if (root == null) return null;
        // If either a or b matches with root, then root is the LCA
        if (root.data == a || root.data == b) return root;
        // Recur for left and right subtrees
        Node leftLCA = findLCA(root.left, a, b);
        Node rightLCA = findLCA(root.right, a, b);
        // If both left and right return non-null, then root is the LCA
        if (leftLCA != null && rightLCA != null) return root;
        // Otherwise return the non-null value
        return (leftLCA != null) ? leftLCA : rightLCA;
    }
    // To find the distance from the LCA to the target node
    int findLevel(Node root, int target, int level) {
        if (root == null) return -1;
        // If we found the target node, return the level (distance)
        if (root.data == target) return level;
        // Recursion for left and right subtrees
        int left = findLevel(root.left, target, level + 1);
        if (left == -1) {
            return findLevel(root.right, target, level + 1);
        }
        return left;
    }
}
