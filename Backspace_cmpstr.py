class Solution:
    def backspaceCompare(self, s: str, t: str) -> bool:
        def help(str1):
            st=[]
            for ch in str1:
                if ch!='#':
                    st.append(ch)
                elif st:
                    st.pop()
            return st
        return help(s)==help(t)
