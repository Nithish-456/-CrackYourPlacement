class Solution:
    def size(self, head):
        c=0
        while head:
            c+=1
            head=head.next
        return c
    
    def revgrp(self, head, k, len):
        if len<k:
            return head
        curr=head
        prev, next = None, None
        c=0
        while curr and c<k:
            next=curr.next
            curr.next=prev
            prev=curr
            curr=next
            c+=1
        if next:
            head.next = self.revgrp(next, k, len-k)
        return prev
    def reverseKGroup(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        len = self.size(head)
        return self.revgrp(head, k, len)
