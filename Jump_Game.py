class Solution:
    def canJump(self, nums: List[int]) -> bool:
        res =0
        for x in nums:
            if res<0:
                return False
            elif x>res:
                res = x
            res-=1
        return True
        
