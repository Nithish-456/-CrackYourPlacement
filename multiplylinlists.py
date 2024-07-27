class node:
    def __init__(self):
        self.data = None
        self.next = None

class Solution:
    def multiply_two_lists(self, first, second):
        MOD = 10**9 + 7
        
        def linked_list_to_number(head):
            number = 0
            while head:
                number = (number * 10 + head.data) % MOD
                head = head.next
            return number
        num1 = linked_list_to_number(first)
        num2 = linked_list_to_number(second)
        # Multiply the numbers and take modulo
        result = (num1 * num2) % MOD
        
        return result
