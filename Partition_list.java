class Solution {
    public ListNode partition(ListNode head, int x) {
        // Create 2 dummy lists to ensure the partition
        ListNode before_x = new ListNode(0);
        ListNode after_x = new ListNode(0);

        // The above pointers will used to traverse the lists.
        ListNode before = before_x;
        ListNode after = after_x;

        // Traverse the original list and partition it into two lists
        while (head != null) {
            if (head.val < x) {
                before.next = head;
                before = before.next;
            } else {
                after.next = head;
                after = after.next;
            }
            head = head.next;
        }      
        // Ensure the end of the after list points to null
        after.next = null; 
        // Connect the before list with the after list
        before.next = after_x.next;       
        // Return the head of the new partitioned list
        return before_x.next;        
    }
}
