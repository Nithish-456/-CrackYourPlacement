class Solution {
    public ListNode sortList(ListNode head) {
        if (head==null || head.next==null){
            return head;
        }
        // Split the list into 2 halves and keep mid.next=null
        ListNode mid = middle(head);
        ListNode left = head;
        ListNode right = mid.next;
        mid.next = null;

        // Sort each half recursively
        left = sortList(left);
        right = sortList(right);
        
        return merge(left, right);
    }
    private ListNode middle(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    // Merge 2 linked lists
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dum = new ListNode(0);
        ListNode tail = dum;      
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }      
        // Append the remaining nodes of l1 or l2
        if (l1 != null) {
            tail.next = l1;
        } else {
            tail.next = l2;
        }      
        return dum.next;   
    }
}
