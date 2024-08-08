class Solution:
    def combine(self, n: int, k: int) -> List[List[int]]:
        def helper(s=1, res=[]):
            if len(res) == k:
                res1.append(res[:])
                return
            
            for i in range(s,n+1):
                res.append(i)
                helper(i+1, res) # to check possibilty with another number
                res.pop() # we will pop this
        res1=[]
        helper()
        return res1

        
