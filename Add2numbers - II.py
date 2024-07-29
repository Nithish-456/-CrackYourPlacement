class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        size1= self.getsize(l1)
        size2=self.getsize(l2)

        # Pad the shorter linked list with zeros to maintain the same length equality
        if size1<size2:
            l1=self.pad(l1, size2-size1)
        elif size2<size1:
            l2=self.pad(l2, size1-size2)

        # Perform the Addition
        sum1, car = self.add(l1, l2)

        # If there is carry, add it to the new node
        if car>0:
            sum1 = ListNode(car, sum1)
        return sum1
    def add(self, l1:ListNode, l2:ListNode)-> tuple:
        # Base case: if both lists are empty, return (None, 0)
        if not l1 and not l2:
            return None,0
        # Recursively calling next nodes to process the entire linkedlist
        next_sum, car = self.add(l1.next,l2.next)

        # Caluclating sum and carry of current nodes
        curr_sum = l1.val+l2.val+car
        new_car = curr_sum//10
        digit = curr_sum%10

        curr = ListNode(digit)
        curr.next = next_sum

        return curr, new_car
    def getsize(self, head:ListNode) -> int:
        l=0
        while head:
            l+=1
            head=head.next
        return l

    def pad(self, head: ListNode, padding: int) -> ListNode:
        for _ in range(padding):
            new_head = ListNode(0)
            new_head.next = head
            head = new_head
        return head
