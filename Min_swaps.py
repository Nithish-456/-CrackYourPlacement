    
    #Function to find the minimum number of swaps required to sort the array.
	def minSwaps(self, nums):
		n = len(nums)
		arr = list(enumerate(nums))
		arr.sort(key=lambda it: it[1])
		vis = [False] * n
		res = 0
		for i in range(n):
        # If element is visited or already in correct position
            if vis[i] or arr[i][0] == i:
                continue
            cycle_size = 0
            j = i
            while not vis[j]:
                vis[j] = True
                j = arr[j][0]
                cycle_size += 1
		    res += cycle_size - 1
		return res
