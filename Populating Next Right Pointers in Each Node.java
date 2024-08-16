class Solution {
    public Node connect(Node root) {
        if (root == null) return null;
        Node main = root;
        while (main.left!=null){ // level by level
            Node curr=main; // all nodes at current level
            while(curr!=null){
                curr.left.next = curr.right;
            if (curr.next!=null) // not last node in the current level
            curr.right.next=curr.next.left;
            curr=curr.next;
            }
            main=main.left; // when curr becomes null
        }
        return root;       
    }
}
