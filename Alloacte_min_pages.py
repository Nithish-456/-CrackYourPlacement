class Solution:
    
    #Function to find minimum number of pages.
    def findPages(self,n ,arr ,m):
        if m>n:
            return -1   
        def is_valid(max_pages):
            stu = 1
            pages = 0
            for book in arr:
                if book>max_pages:
                    return False
                if pages + book > max_pages:
                    stu+=1
                    pages = book
                else:
                    pages+=book
                if stu>m:
                    return False
            return True
        l,r = max(arr), sum(arr)
        res = -1
        while l<=r:
            mid = (l+r)//2
            if is_valid(mid):
                res = mid
                r=mid-1
            else:
                l=mid+1
        return res
