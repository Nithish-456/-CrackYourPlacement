from itertools import permutations
class Solution:
    def uniquePerms(self, arr, n):
        # code here 
        per = permutations(arr)
        per1 = set(per)
        per2 = sorted(per1)
        sorted_perms = [list(pe) for pe in per2]
        
        return sorted_perms
