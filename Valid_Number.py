class Solution:
    def isNumber(self, s: str) -> bool:
        pat = r'^[+-]?(\d+\.?\d*|\.\d+)([eE][+-]?\d+)?$'
        return bool(re.match(pat, s))
        
