class Solution:
    def splitArray(self, nums: List[int], k: int) -> int:
        if k==1:
            return sum(nums)
        l,r = max(nums), sum(nums)
        while l<=r:
            mid =(l+r)//2
            max_sum=0
            splits=1
            for i in nums:
                max_sum+=i
                if max_sum<=mid:
                    continue
                else:
                    splits+=1
                    max_sum=i
            
            if splits>k:
                l=mid+1
            else:
                r=mid-1
        return l
        
