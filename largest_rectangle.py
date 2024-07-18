class Solution:
    def largestRectangleArea(self, arr: List[int]) -> int:
        arr.append(0)
        st = [-1]
        marea = 0
        for i in range(len(arr)):
            while arr[i] < arr[st[-1]]:
                height = arr[st.pop()]
                width = i - st[-1] -1 
                marea = max(marea, height*width)
            st.append(i)
        arr.pop()
        return marea
