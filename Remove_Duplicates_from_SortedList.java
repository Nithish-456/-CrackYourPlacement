class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head==null){
            return null;
        }
        ListNode dum = new ListNode(0);
        dum.next=head;
        ListNode prev = dum;
        ListNode curr = head;
        while (curr != null) {
            // Check if current node is a start of a sequence of duplicates
            if (curr.next != null && curr.val == curr.next.val) {
                // Skip all nodes with the same value
                while (curr.next != null && curr.val == curr.next.val) {
                    curr = curr.next;
                }
                // Link prev node to the next node after the duplicates
                prev.next = curr.next;
            } else {
                // Move prev only when no duplicate was found
                prev = prev.next;
            }
            // Move to the next node
            curr = curr.next;
        }
        return dum.next;
    }
}
