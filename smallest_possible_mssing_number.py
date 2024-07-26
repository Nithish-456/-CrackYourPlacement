class Solution:
    def missingNumber(self,arr,n):
        for i in range(n):
            if arr[i]<=0 or arr[i]>n:
                arr[i]=n+1
        for i in range(n):
            num = abs(arr[i])
            if num<=n:
                arr[num-1] = -abs(arr[num-1])
        for i in range(n):
            if arr[i]>0:
                return i+1
        return n+1
