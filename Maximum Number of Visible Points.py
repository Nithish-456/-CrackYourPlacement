class Solution:
    def visiblePoints(self, points: List[List[int]], angle: int, location: List[int]) -> int:
        c=0
        angles=[]
        x1,y1=location
        for p in points:
            px,py = p
            if px==x1 and py==y1:
                c+=1
            else:
# For each point, calculate the angle it forms with the location using atan2.
# For each point, calculate the angle it forms with the location using atan2, which returns the angle in radians. 
# Convert it to degrees using degrees.
                angle_to_point = math.atan2(py - y1, px - x1)
                angles.append(math.degrees(angle_to_point))
        angles.sort()
        # To handle the circular nature, we duplicate the angles with +360 degrees
        angles = angles + [x + 360 for x in angles]
        max_visible=0
        left=0
        for right in range(len(angles)):
            while angles[right] - angles[left] > angle:
                left += 1
            max_visible = max(max_visible, right - left + 1)
        
        return max_visible + c 
        
