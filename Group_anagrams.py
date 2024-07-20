class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        map1 = defaultdict(list)
        for w in strs:
            sorted_w = ''.join(sorted(w))
            map1[sorted_w].append(w)
        return list(map1.values())        
