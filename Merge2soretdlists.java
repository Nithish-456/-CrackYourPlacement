class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dum=new ListNode(-1);
        ListNode res=dum;
        ListNode ptr1=list1;
        ListNode ptr2=list2;
        while(ptr1!=null&&ptr2!=null){
            if(ptr1.val<ptr2.val){
                dum.next=ptr1;
                ptr1=ptr1.next;
            }else{
                dum.next=ptr2;
                ptr2=ptr2.next;
            }
            dum=dum.next;
        }
        if (ptr1==null){
            dum.next=ptr2;
        }else{
            dum.next=ptr1;
        }
        return res.next;        
    }
}
