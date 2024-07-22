class Solution:
    def fullJustify(self, words: List[str], maxWidth: int) -> List[str]:
        ans, curr_line, wd = [],[],0

        for w in words:
            if wd + len(w) + len(curr_line) > maxWidth:
                for i in range(maxWidth - wd): curr_line[i % (len(curr_line) - 1 or 1)] += ' '
                ans, curr_line, wd = ans + [''.join(curr_line)], [], 0
            curr_line +=[w]
            wd+=len(w)
        return ans + [' '.join(curr_line).ljust(maxWidth)]
        
