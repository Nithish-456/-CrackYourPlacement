class Solution:
    def countSmaller(self, nums: List[int]) -> List[int]:
        def merge_sort(enums):
            if len(enums) <= 1:
                return enums
            mid = len(enums) // 2
            left = merge_sort(enums[:mid])
            right = merge_sort(enums[mid:])
            return merge(left, right)
        def merge(left, right):
            merged = []
            i, j = 0, 0
            while i < len(left) and j < len(right):
                if left[i][1] <= right[j][1]:
                    merged.append(left[i])
                    counts[left[i][0]] += j
                    i += 1
                else:
                    merged.append(right[j])
                    j += 1
            while i < len(left):
                merged.append(left[i])
                counts[left[i][0]] += j
                i += 1
            while j < len(right):
                merged.append(right[j])
                j += 1
            return merged
        counts = [0] * len(nums)
        merge_sort(list(enumerate(nums)))
        return counts
            
            
