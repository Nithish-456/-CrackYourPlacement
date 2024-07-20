Link: https://www.geeksforgeeks.org/problems/smallest-window-in-a-string-containing-all-the-characters-of-another-string-1587115621/1
from collections import Counter
class Solution:
    
    #Function to find the smallest window in the string s consisting
    #of all the characters of string p.
    def smallestWindow(self, s, p):
        if not s or not p:
            return "-1"
        dict_p = Counter(p)
        required = len(dict_p)

        l, r = 0, 0
        formed = 0
        window_counts = {}

        ans = float("inf"), None, None
    
        while r < len(s):
            character = s[r]
            window_counts[character] = window_counts.get(character, 0) + 1
        
            if character in dict_p and window_counts[character] == dict_p[character]:
                formed += 1

            while l <= r and formed == required:
                character = s[l]

                if r - l + 1 < ans[0]:
                    ans = (r - l + 1, l, r)

                window_counts[character] -= 1
                if character in dict_p and window_counts[character] < dict_p[character]:
                    formed -= 1
    
                l += 1

            r += 1
        return s[ans[1]: ans[2] + 1] if ans[0] != float("inf") else "-1"
