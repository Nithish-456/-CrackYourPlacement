class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head==null||head.next==null){
            return head;
        }
        ListNode res = new ListNode(-1);
        res.next=head;
        ListNode curr = res;
        ListNode prev = null;
        // Find the left and previous left for the reverse operation
        for (int i=0; i<left;i++){
            prev = curr;
            curr=curr.next;
        }
        ListNode prev1 = prev;
        ListNode curr1=curr;
        // Now, run the loop from given left to right position
        for (int i = left;i<=right;i++){
            ListNode curr2 = curr1.next;
            curr1.next=prev1;
            prev1=curr1;
            curr1=curr2;
        }
        prev.next = prev1;
        curr.next=curr1;
        return res.next;
        
    }
}
