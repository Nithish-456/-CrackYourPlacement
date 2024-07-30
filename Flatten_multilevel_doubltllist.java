/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if (head == null){
            return head;
        }
        Node curr=head;
        // If the current node has no child, we will proceed in further.
        while (curr!=null){
            if (curr.child == null){
                curr=curr.next;
                continue;

            }      
        // If there is a child connected to the current node means, 
        // we will iterate to the end of child list and connect it to curr.next
        Node temp = curr.child;
        while (temp.next!=null)
            temp=temp.next;
        temp.next = curr.next;
        // Then, we will connect curr with curr.child and remove child list
        if (curr.next!=null)
            curr.next.prev=temp;
            curr.next=curr.child;
            curr.child.prev=curr;
            curr.child = null;
        }
        return head;
    }
}
