from collections import defaultdict
class Solution:
    def Anagrams(self, words, n):
        dict1 = defaultdict(list)
        for w in words:
            sorted_w = ''.join(sorted(w))
            dict1[sorted_w].append(w)
        anagram_groups = list(dict1.values())
    
    # Sort each group lexicographically by the order of appearance in the original list
        for group in anagram_groups:
          group.sort(key=lambda x: words.index(x))
    # Sort groups based on the first element in each group to maintain appearance order
        anagram_groups.sort(key=lambda x: words.index(x[0]))
        return anagram_groups
