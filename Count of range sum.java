class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        // Step 1: Create a prefix sum array
        long[] prefixSum = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        // Step 2: Use merge sort to count the valid range sums
        return countWhileMergeSort(prefixSum, 0, prefixSum.length, lower, upper);
    }

    private int countWhileMergeSort(long[] prefixSum, int start, int end, int lower, int upper) {
        if (end - start <= 1) {
            return 0;
        }

        int mid = (start + end) / 2;
        int count = countWhileMergeSort(prefixSum, start, mid, lower, upper)
                  + countWhileMergeSort(prefixSum, mid, end, lower, upper);

        int j = mid, k = mid, t = mid;
        long[] temp = new long[end - start];
        int r = 0;

        for (int i = start; i < mid; i++) {
            // Count the number of valid range sums
            while (k < end && prefixSum[k] - prefixSum[i] < lower) k++;
            while (j < end && prefixSum[j] - prefixSum[i] <= upper) j++;

            // Merge the sorted arrays
            while (t < end && prefixSum[t] < prefixSum[i]) {
                temp[r++] = prefixSum[t++];
            }
            temp[r++] = prefixSum[i];

            // Add the count of valid sums
            count += j - k;
        }

        // Copy the sorted array back
        System.arraycopy(temp, 0, prefixSum, start, t - start);
        return count;
    }
}
