from collections import deque
class Solution:
    
    def findMaxValueOfEquation(self, points: List[List[int]], k: int) -> int:
        dq = deque()
        res = -float('inf')
        # Iterate over each point (x, y)
        for x, y in points:
            # Remove points from the deque if they are out of the range of k
            while dq and dq[0][0] < x - k:
                dq.popleft()
            # If the deque is not empty, calculate the potential maximum value
            if dq:
                res = max(res, dq[0][1] + y + x)
            # Remove points from the deque if they do not contribute to the maximum y - x
            while dq and dq[-1][1] <= y - x:
                dq.pop()
            # Add the current point to the deque
            dq.append((x, y - x))
        
        # Return the maximum value found
        return res
                
