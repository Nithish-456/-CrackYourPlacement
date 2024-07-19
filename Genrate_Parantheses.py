class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        def find(l,r,s):
            if len(s) == n*2:
                res.append(s)
                return

            if l<n:
                find(l+1, r, s + '(')
            if r<l:
                find(l,r+1, s + ')')
        res = []
        find(0,0,'')
        return res
        
