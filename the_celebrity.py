class Solution:
    def knows(self,a,b, matrix):
        return matrix[a][b]==1
        
    def celebrity(self, mat):
        st=[]
        n=len(mat)
        res = -1 # Celebrity
        for i in range(n):
            st.append(i)
        while len(st)>1:
            a=st.pop()
            b=st.pop()
            if self.knows(a,b,mat):
                st.append(b)
            else:
                st.append(a)
        c=st.pop()
        for i in range(n):
        # If any person doesn't know 'c' or 'c' doesn't know any person, return -1
            if i != c and (self.knows(c, i, mat) or not self.knows(i, c, mat)):
                return -1
        return c
