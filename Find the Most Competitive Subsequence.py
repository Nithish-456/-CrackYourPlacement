class Solution:
    def mostCompetitive(self, nums: List[int], k: int) -> List[int]:
        st=[]
        for i, num in enumerate(nums):
            while st and st[-1]>num and len(nums) - i>k-len(st):
                st.pop()
            st.append(num)
        return st[:k]
