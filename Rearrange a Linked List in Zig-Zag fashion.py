def zigZagList(head):
    # If flag is true, then next node should be greater
    # in the desired output.
    flag = True
    # Traverse linked list starting from head.
    current = head
    while (current.next != None):     
        if (flag): # "<" relation expected         
            # If we have a situation like A > B > C
            # where A, B and C are consecutive Nodes
            # in list we get A > B < C by swapping B
            # and C 
            if (current.data > current.next.data):
                t = current.data
                current.data = current.next.data
                current.next.data = t         
        else :# ">" relation expected         
            # If we have a situation like A < B < C where
            # A, B and C are consecutive Nodes in list we
            # get A < C > B by swapping B and C 
            if (current.data < current.next.data):
                t = current.data
                current.data = current.next.data
                current.next.data = t             
        current = current.next
        if(flag):
            flag = False # flip flag for reverse checking 
        else:
            flag = True
    return head
