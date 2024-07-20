class Solution:
    def simplifyPath(self, path: str) -> str:
        st = []
        dire = path.split('/')
        for di in dire:
            if di == '.' or not di:
                continue
            elif di == '..':
                if st:
                    st.pop()
            else:
                st.append(di)
        return '/' + '/'.join(st)
        
