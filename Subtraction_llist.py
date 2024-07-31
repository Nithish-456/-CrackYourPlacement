class Solution:
    def subLinkedList(self, l1, l2): 
        num1,num2=[],[]
        while l1:
            num1.append(l1.data)
            l1=l1.next
        while l2:
            num2.append(l2.data)
            l2=l2.next
        n1,n2='',''
        for i in num1:
            n1+=str(i)
        for i in num2:
            n2+=str(i)
        res=abs(int(n1)-int(n2))
        res=Node(res)
        return res
