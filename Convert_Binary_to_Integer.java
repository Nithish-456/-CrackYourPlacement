/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int getDecimalValue(ListNode head) {
        ListNode temp = head;
        int c = 0;
        while(temp!=null){
            c++;
            temp=temp.next;
        }
        int i = c-1;
        temp=head;
        int res =0;
        while (temp!=null){
            if (temp.val==1){
                res+=Math.pow(2,i);
            }
            i--;
            temp=temp.next;
        }
        return res;

        
    }
}
