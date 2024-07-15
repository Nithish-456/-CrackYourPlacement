# Start with an initial prefix sum of 0.
As you go through each number in the array, update the prefix sum by adding the current number.
Calculate the remainder of this prefix sum when divided by ( k ).
Use the hash map to check if this remainder has been seen before:
If it has, it means there are subarrays that sum to a multiple of ( k ), and you increase your count by how many times this remainder has been seen.
Update the hash map to include this new remainder.

class Solution:
    def subarraysDivByK(self, nums: List[int], k: int) -> int:
        c=0
        psum=0
        pmap={0:1}
        for num in nums:
            psum+=num
            mod = psum%k
            if mod<0:
                mod+=k
            if mod in pmap:
                c+=pmap[mod]
                pmap[mod]+=1
            else:
                pmap[mod]=1
        return c
