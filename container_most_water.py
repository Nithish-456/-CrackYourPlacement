class Solution:
    def maxArea(self, height: List[int]) -> int:
        l=0
        r=len(height)-1
        maxa=0
        while l<r:
            width=r-l
            curra=min(height[l],height[r])
            water=width*curra
            maxa=max(maxa,water)
            if height[l]<height[r]:
                l+=1
            else:
                r-=1
        return maxa
        
