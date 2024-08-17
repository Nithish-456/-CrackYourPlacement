class Solution
{
    Node prev = null;
    Node head = null;
    Node bToDLL(Node root)
    {
        if (root == null) return null;
        bToDLL(root.left);
        if (prev == null) {
            head = root;
        } else {
            prev.right = root;
            root.left = prev;
        }
        prev = root;
        bToDLL(root.right);
        return head;
	    	
    }
}
