class GfG
{
    int maxLen(int arr[], int n)
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max_len=0;
        int curr_sum=0;
        for (int i=0;i<n;i++){
            curr_sum+=arr[i];
            if (curr_sum==0){
                max_len=i+1;
            }
            // If the cumulative sum has been seen before
            if (map.containsKey(curr_sum)) {
                // Update maxLen if the subarray is longer than the current maxLen
                max_len = Math.max(max_len, i - map.get(curr_sum));
            } else {
                // Otherwise, put the cumulative sum and its index into the map
                map.put(curr_sum, i);
            }
        }
        return max_len;
    }
}
