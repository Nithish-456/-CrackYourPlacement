class Solution:
    def furthestBuilding(self, heights: List[int], bricks: int, ladders: int) -> int:
        pq = []
        for i in range(1, len(heights)):
            if (diff:=heights[i] - heights[i-1])>0:
                heappush(pq,diff)

                if len(pq)>ladders:
                    bricks-=heappop(pq)
                    if bricks<0:
                        return i-1
        return len(heights)-1
        
