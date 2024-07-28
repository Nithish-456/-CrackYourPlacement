public class Solution {
    public int size1(ListNode head){
            int c=0;
            ListNode ptr=head;
            while(ptr!=null){
                c++;
                ptr=ptr.next;
            }
            return c;
        }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null){
            return null;
        }
        int l1=size1(headA);
        int l2=size1(headB);
        int diff=l1-l2;
        ListNode ptr1=headA;
        ListNode ptr2=headB;
        if(diff>0){
            while(diff>0){
                ptr1=ptr1.next;
                diff--;
            }
        }else{
            while(diff<0){
                ptr2=ptr2.next;
                diff++;
            }
        }
        while(ptr1!=ptr2){
            ptr1=ptr1.next;
            ptr2=ptr2.next;
        }
        return ptr1;    
    }
}
