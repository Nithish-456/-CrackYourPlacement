class Solution:
    def removeDuplicates(self, s: str, k: int) -> str:
        st=[]
        for ch in s:
            if st and st[-1][0]==ch:
                st[-1][1]+=1
                if st[-1][1]==k:
                    st.pop()
            else:
                st.append([ch,1])
        res= ''.join(ch*count for ch,count in st)
        return res
        if any(count>=k for _,count in st):
            return -1
        return res
        
