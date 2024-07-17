class Solution:
    def reversePairs(self, nums: List[int]) -> int:
        self.c=0
        def merge(left,right):
            i,j=0,0
            while i<len(left) and j<len(right):
                if left[i] > 2*right[j]:
                    self.c+=len(left) - i
                    j+=1
                else:
                    i+=1
            l,r = 0,0
            res = []
            while l<len(left) and r<len(right):
                if left[l]<right[r]:
                    res.append(left[l])
                    l+=1
                else:
                    res.append(right[r])
                    r+=1
            return res + left[l:] +right[r:]
        def divide(arr):
            if len(arr) <=1:
                return arr
            mid = len(arr)//2
            left = divide(arr[:mid])
            right = divide(arr[mid:])
            return merge(left,right)
        nums = divide(nums)
        return self.c
        
