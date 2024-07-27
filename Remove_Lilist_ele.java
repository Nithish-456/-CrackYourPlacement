class Solution {
    public ListNode removeElements(ListNode head, int val) {
if (head==null){
return null;
}
ListNode res = new ListNode(-1);
res.next=head;
ListNode curr = res;
while (curr.next!=null){
if (curr.next.val==val){
curr.next=curr.next.next;
}else{
curr=curr.next;
}}
return res.next;
}}
        
