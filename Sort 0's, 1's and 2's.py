class LinkedList(obj):
def ___init__(self):
    self.head = None
class Node(obj):
    def __init__(self,d):
        self.data=d
        self.next=None
    def sortlist(self):
        counts = [0,0,0]
        temp=self.head
        while temp!=None:
              counts[temp.data]+=1
              temp=temp.next
    i=0
    temp=self.head
    while ptr != None:
            if count[i] == 0:
                i+=1
            else:
                ptr.data = i
                count[i]-=1
                ptr = ptr.next
