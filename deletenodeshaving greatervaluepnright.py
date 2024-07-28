class Solution:
    def compute(self,head):
        def reverse(node):
            prev=None
            curr=node
            while curr:
                next_node = curr.next
                curr.next=prev
                prev=curr
                curr = next_node
            return prev
        head = reverse(head)
        
        curr=head
        maxi = head.data
        while curr.next:
            if curr.next.data<maxi:
                curr.next = curr.next.next
            else:
                curr=curr.next
                maxi=curr.data
        return reverse(head)
