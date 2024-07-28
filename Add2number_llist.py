class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        dum= ListNode(0)
        curr=dum
        car=0
        while l1!=None or l2!=None or car!=0:
              l1val = l1.val if l1 else 0
              l2val = l2.val if l2 else 0
              column_sum = l1val+l2val+car
              car=column_sum//10
              new_node = ListNode(column_sum%10)
              curr.next=new_node
              curr=new_node
              l1 = l1.next if l1 else None
              l2 = l2.next if l2 else None
      return dum.next
