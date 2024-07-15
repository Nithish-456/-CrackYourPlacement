class Solution:
    def findDuplicates(self, nums: List[int]) -> List[int]:
        a1 = [0]*(len(nums)+1)
        for n in nums:
            a1[n]+=1
        res=[]
        for i in range(len(a1)):
            if a1[i]==2:
                res.append(i)
        return res
        
