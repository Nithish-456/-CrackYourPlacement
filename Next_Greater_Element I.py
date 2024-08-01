class Solution:
    def nextGreaterElement(self, nums1: List[int], nums2: List[int]) -> List[int]:
        if not nums2:
            return None
        res=[]
        st=[]
        map1={}
        st.append(nums2[0])
        for i in range(1, len(nums2)):
            while st and nums2[i]>st[-1]:
                map1[st[-1]] = nums2[i]
                st.pop()
            st.append(nums2[i])
        for e in st:
            map1[e]=-1
        for i in range(len(nums1)):
            res.append(map1[nums1[i]])
        return res
