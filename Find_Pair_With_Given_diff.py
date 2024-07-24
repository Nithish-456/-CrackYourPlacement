class Solution:
    def findPair(self, n : int, x : int, arr : List[int]) -> int:
        arr.sort()
        l,r = 0, 1
        while l<n and r<n:
            diff = arr[r] - arr[l]
            
            if diff == x and l!=r:
                return 1
            
            if diff < x:
                r+=1
            else:
                l+=1
        return -1
