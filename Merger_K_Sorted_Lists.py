class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        d = defaultdict(int)
        for i in lists:
            head = ListNode(0)
            head.next=i
            head=head.next
            while head:
                d[head.val]+=1
                head=head.next
        head = ListNode(0)
        curr = head
        res = sorted(d.keys())
        while res:
            k = res.pop(0)
            for i in range(d[k]):
                curr.next=ListNode(k)
                curr=curr.next
        return head.next
