class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        res = []
        n = len(nums)
        nums.sort()
        def helper(idx, comb):
            if comb not in res:
                res.append(comb)

            for i in range(idx, n):
                sub_comb = comb + [nums[i]]
                helper(i + 1, sub_comb) 

        helper(0, [])
        return res
        
